package com.sichuan.sichuanproject.mapper.primary;

import com.sichuan.sichuanproject.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 */

@Mapper
@Repository
public interface RoleMapper {

    /**
     * 插入角色信息
     *
     * @param role
     * @return
     */
    @Insert("insert into role_info(role_code,role_name,description,valid_status,update_time) values(#{roleCode},#{roleName},#{description},#{validStatus},#{updateTime})")
    Integer insertRole(Role role);

    /**
     * 批量插入角色信息
     *
     * @param roleList
     */
    @Insert("<script>" +
            "insert into role_info(role_code,role_name,description,valid_status,update_time) values " +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.roleCode},#{item.roleName},#{item.description},#{item.validStatus},#{item.updateTime})" +
            "</foreach>" +
            "</script>")
    void insertRoleBatch(@Param("list") List<Role> roleList);

    /**
     * 修改角色信息
     *
     * @param role
     * @return
     */
    @Update("update role_info set role_name=#{roleName},description=#{description},valid_status=#{validStatus},update_time=#{updateTime} where role_code=#{roleCode}")
    Integer updateRole(Role role);

    /**
     * 批量删除角色
     *
     * @param roleCodes
     * @return
     */
    @Delete("<script>" +
            "delete from role_info where role_code in " +
            "<foreach collection='list' item='id' separator=',' open='(' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    Integer deleteRoles(@Param("list") List<Long> roleCodes);

    /**
     * 根据roleCode查找角色信息
     *
     * @param roleCode
     * @return
     */
    @Select("select * from role_info where role_code=#{roleCode}")
    Role getRoleById(Long roleCode);
}
