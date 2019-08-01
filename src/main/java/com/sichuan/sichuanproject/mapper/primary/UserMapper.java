package com.sichuan.sichuanproject.mapper.primary;

import com.sichuan.sichuanproject.domain.Menu;
import com.sichuan.sichuanproject.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 */

@Mapper
@Repository
public interface UserMapper {

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @Insert("insert into user_info(user_id,user_name,org_id,birth_address,address,mobile,id_code,update_time) values(#{userId},#{userName},#{orgId},#{birthAddress},#{address},#{mobile},#{idCode},#{updateTime})")
    Integer insertUser(User user);

    /**
     * 批量插入用户信息
     *
     * @param userList
     */
    @Insert("<script>" +
            "insert into user_info(user_id,user_name,org_id,birth_address,address,mobile,id_code,update_time) values " +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.userId},#{item.userName},#{item.orgId},#{item.birthAddress},#{item.address},#{item.mobile},#{item.idCode},#{item.updateTime})" +
            "</foreach>" +
            "</script>")
    void insertUserInfoBatch(@Param("list") List<User> userList);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @Update("update user_info set user_name=#{userName},org_id=#{orgId},birth_address=#{birthAddress},address=#{address},mobile=#{mobile},id_code=#{idCode},update_time=#{updateTime} where user_id=#{userId}")
    Integer updateUser(User user);

    /**
     * 根据用户id查找用户信息
     *
     * @param userId
     * @return
     */
    @Select("select * from user_info where user_id=#{userId}")
    User getUserById(Long userId);

    /**
     * 批量删除用户
     *
     * @param userIds
     * @return
     */
    @Delete("<script>" +
            "delete from user_info where user_id in " +
            "<foreach collection='list' item='id' separator=',' open='(' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    Integer deleteUsersByIds(@Param("list") List<Long> userIds);

    /**
     * 根据用户id查找用户可用的菜单
     *
     * @param userId
     * @param orgId
     * @return
     */
    @Select("select * from r_user_and_role ur,r_role_and_menu rm,menu_info m where ur.role_code=rm.role_code and rm.menu_id=m.menu_id and ur.user_id=#{userId} and rm.org_id=#{orgId}")
    List<Menu> getMenuByUserId(@Param("userId") Long userId, @Param("orgId") Long orgId);
}
