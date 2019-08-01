package com.sichuan.sichuanproject.mapper.primary;

import com.sichuan.sichuanproject.domain.UserRole;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 */

@Mapper
@Repository
public interface UserRoleMapper {

    /**
     * 新增用户角色
     *
     * @param userRole
     * @return
     */
    @Insert("insert into r_user_and_role(user_id,org_id,role_code,update_time) values(#{userId},#{orgId},#{roleCode},#{updateTime})")
    Integer insertUserRole(UserRole userRole);

    /**
     * 批量增加用户角色信息
     *
     * @param userRoleList
     * @return
     */
    @Insert("<script>" +
            "insert into r_user_and_role(user_id,role_code,org_id,update_time) values " +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.userId},#{item.roleCode},#{item.orgId},#{item.updateTime})" +
            "</foreach>" +
            "</script>")
    int insertUserRoleBatch(@Param("list") List<UserRole> userRoleList);

    /**
     * 修改用户角色
     *
     * @param userRole
     * @return
     */
    @Update("update r_user_and_role set role_code=#{roleCode},update_time=#{updateTime} where user_id=#{userId} and org_id=#{orgId}")
    Integer updateUserRole(UserRole userRole);

    /**
     * 获取用户角色
     *
     * @param userId
     * @param orgId
     * @return
     */
    @Select("select * from r_user_and_role where user_id=#{userId} and org_id=#{orgId}")
    UserRole getUserRoleById(@Param("userId") Long userId, @Param("orgId") Long orgId);

    /**
     * 删除用户角色
     *
     * @param userId
     * @param orgId
     * @return
     */
    @Delete("delete from r_user_and_role where user_id=#{userId} and org_id=#{orgId}")
    Integer deleteUserRoleById(@Param("userId") Long userId, @Param("orgId") Long orgId);
}
