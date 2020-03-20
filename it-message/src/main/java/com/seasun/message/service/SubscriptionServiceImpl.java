package com.seasun.message.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seasun.message.constant.MessageChannel;
import com.seasun.message.constant.SubscriberType;
import com.seasun.message.mapper.SubscriptionMapper;
import com.seasun.message.model.Subscription;
import com.seasun.message.model.extension.BaseSubscriber;
import com.seasun.message.model.extension.MessageSubject;
import com.seasun.message.model.extension.SubjectSubscriber;
import com.seasun.message.model.extension.Subscriber;
import com.seasun.message.utils.Lists;
import com.seasun.message.utils.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

import static java.util.stream.Collectors.*;

@Service
public class SubscriptionServiceImpl extends ServiceImpl<BaseMapper<Subscription>, Subscription> implements SubscriptionService {
    private Logger logger = LoggerFactory.getLogger(SubscriptionServiceImpl.class);

    @Autowired
    private SubscriptionMapper subscriptionMapper;

    @Override
    public void subscribe(Long userId, String target, String targetType) {

    }

    @Override
    public void cancelSubscription(Long userId, String target, String targetType) {

    }


    @Override
    public List<Subscription> getSubscription(Long userId) {
        return getSubscription(Lists.newArrayList(userId));
    }

    @Autowired
    private SubscriberHandler handler;

    //todo zhaijie1 bug 当target为null的时候 含义为获取任意targetId
    @Override
    public List<Subscriber> getSubscriber(MessageSubject subject) {
        Assert.notNull(subject, "主题不能为空");
        Assert.notNull(subject.getTargetType(), "主题类型不能为空");

        QueryWrapper<Subscription> wrapper = new QueryWrapper<>(new Subscription());
        wrapper.select("*").eq("target_type", subject.getTargetType())
                .eq(subject.getAction() != null, "action", subject.getAction()).isNull(subject.getAction() == null, "action")
                .eq(subject.getTarget() != null, "target", subject.getTarget()).isNull(subject.getTarget() == null, "target");
        List<Subscription> subscriptions = list(wrapper);
        return addSubscriber(subscriptions).parallelStream().map(Subscription::getSubscriberInstance).collect(toList());
    }

    @Override
    public Subscriber getSubscriber(Long userId) {
        return getSubscription(userId).parallelStream().findFirst().map(Subscription::getSubscriberInstance).orElseThrow(() -> new RuntimeException("查询失败,没有找到结果"));
    }

    @Override
    public List<Subscriber> getSubscriber(List<Long> userIds) {
        Set<Subscriber> collect = getSubscription(userIds).parallelStream().map(Subscription::getSubscriberInstance).collect(toSet());
        return Lists.toList(collect);
    }

    private Map<Long, List<MessageSubject>> getUserSubjects(List<Long> userIds) {
        return getSubscription(userIds).parallelStream().collect(groupingBy(e -> e.getSubscriberInstance().getUserId(), mapping(Subscription::getSubject, toList())));
    }


    private List<Subscription> getSubscription() {
        return addSubscriber(list(null));
    }

    private List<Subscription> getSubscription(List<Long> userIds) {
        List<Subscription> subscription = getSubscription();
        return subscription.parallelStream().filter(e -> userIds.contains(e.getSubscriberInstance().getUserId())).collect(toList());
    }

    private List<Subscription> checkoutSubscribers(List<Subscription> subscriptions, List<Subscriber> subscribers) {
        List<BaseSubscriber> params = subscribers.parallelStream().map(Subscriber::getBaseSubscriber).collect(toList());
        Iterator<Subscription> iterator = subscriptions.iterator();
        while (iterator.hasNext()) {
            BaseSubscriber arg = iterator.next().getBaseSubscriber();
            if (!params.contains(arg)) {
                logger.error("缺少订阅者subscriberId:{},subscriberType:{}", arg.getOriginId(), arg.getSubscriberType());
                iterator.remove();
            }
        }
        return subscriptions;
    }

    private List<Subscription> addSubscriber(List<Subscription> subscriptions, List<Subscriber> subscribers) {
        List<Subscription> checkoutSubscribers = checkoutSubscribers(subscriptions, subscribers);
        List<Subscription> res = new ArrayList<>();
        Map<BaseSubscriber, List<Subscriber>> subscriberListMap = subscribers.parallelStream().collect(groupingBy(Subscriber::getBaseSubscriber));


        for (Subscription subscription : checkoutSubscribers) {
            Long userId = subscription.getSubscriber();
            for (Subscriber subscriber : subscriberListMap.get(BaseSubscriber.create(subscription.getSubscriberType(), userId))) {
                Subscription subscriptionClone = subscription.clone();
                SubjectSubscriber subjectSubscriber = new SubjectSubscriber(subscriber, subscription.getSubject());
                subscriptionClone.setSubscriberInstance(subjectSubscriber);
                res.add(subscriptionClone);
            }
        }
        Map<Long, List<Subscription>> subscriptionsMap = getSubscriptionsMap(res);
        Map<Long, List<MessageSubject>> userSubjectMap = getUserSubjectMap(res);
        for (Subscription subscription : res) {
            SubjectSubscriber subscriberInstance = (SubjectSubscriber) subscription.getSubscriberInstance();
            Long userId = subscriberInstance.getUserId();
            HashSet<MessageSubject> subjects = new HashSet<>(userSubjectMap.get(userId));
            subscriberInstance.setSubscriptionList(subscriptionsMap.get(userId));
            subscriberInstance.setMessageSubjects(subjects);
            subscription.setSubscriberInstance(subscriberInstance);
        }
        return res;
    }


    private List<Subscription> addSubscriber(List<Subscription> subscriptions) {
        Map<SubscriberType, List<Long>> param = subscriptions.parallelStream().collect(groupingBy(e -> SubscriberType.valueOf(e.getSubscriberType()), HashMap::new, mapping(Subscription::getSubscriber, toList())));
        List<Subscriber> subscribers = handler.getByMap(param);
        return addSubscriber(subscriptions, subscribers);
    }

    private Map<Long, List<Subscription>> getSubscriptionsMap(List<Subscription> subscriptions) {
        return subscriptions.parallelStream().collect(groupingBy(e -> e.getSubscriberInstance().getUserId()));
    }

    private Map<Long, List<MessageSubject>> getUserSubjectMap(List<Subscription> subscriptions) {
        return subscriptions.parallelStream().collect(groupingBy(e -> e.getSubscriberInstance().getUserId(), mapping(Subscription::getSubject, toList())));
    }

}
