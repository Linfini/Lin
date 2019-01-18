package com.zaki.mapper;

import com.zaki.model.UserExpand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface UserExpandMapper {
    @Delete({
        "delete from user_expand",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user_expand (user_name, external, ",
        "profile, nick_name, ",
        "create_time, update_time)",
        "values (#{userName,jdbcType=VARCHAR}, #{external,jdbcType=BIT}, ",
        "#{profile,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserExpand record);

    int insertSelective(UserExpand record);

    @Select({
        "select",
        "id, user_name, external, profile, nick_name, create_time, update_time",
        "from user_expand",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.zaki.mapper.UserExpandMapper.BaseResultMap")
    UserExpand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserExpand record);

    @Update({
        "update user_expand",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "external = #{external,jdbcType=BIT},",
          "profile = #{profile,jdbcType=VARCHAR},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserExpand record);
}