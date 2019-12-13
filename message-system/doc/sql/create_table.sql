create table m_message(
	id bigint(20) not null primary key,
    content text not null,
    `type` varchar(200) not null key comment '类型,私信 公告 普通消息',
    target bigint(20) not null key comment '目标,如订单id',
    target_type varchar(50) key not null comment '类型,如订单,系统配置',
    action varchar(200) key not null comment '消息动作,新增,修改,报销等',
    sender bigint(20) not null comment '发送者',
    create_time datetime not null
)engine=INNODB default charset=utf8 comment '消息表';

create table m_message_notify(
	id bigint(20) not null primary key,
    user bigint(20) not null comment '消息所有者',
    state varchar(200) comment '状态:未读,忽略,删除,确认',
	message_id bigint(20) comment 'm_message id',
	channel varchar(200) not null comment '消息分发方式,站内信,邮件,wechat,sms等',
	create_time datetime not null,
	foreign key(message_id) references m_message(id) on delete cascade
)engine=INNODB default charset=utf8 comment '消息接收者关联表';

create table m_sub_scription(
	id bigint(20) not null primary key,
	target bigint(20) not null key comment '目标,如订单id',
    target_type varchar(50) key not null comment '类型,如订单,系统配置',
    action varchar(200) key not null comment '消息动作,新增,修改,报销等',
    channel varchar(200) not null comment '订阅方式,inside,email,wechat,sms等',
	subscriber bigint(20) not null comment '订阅者',
	subscriber_type varchar(20) not null comment '订阅者类型,个人用户,角色用户组,自定义用户组等'
)engine=INNODB default charset=utf8 comment '订阅表';

create table m_message_template(
	id bigint(20) not null primary key,
	target_type varchar(50) key not null comment '类型,如订单,系统配置',
    action varchar(200) key not null comment '消息动作,新增,修改,报销等',
    type varchar(200) default 'default' comment '模板类型:默认,英语,日语',
    template text not null comment '模板'
)engine=INNODB default charset=utf8 comment '消息模板表';

