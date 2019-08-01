package com.sichuan.sichuanproject.mapper.primary;

import com.sichuan.sichuanproject.domain.RoleMenu;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 */

@Mapper
@Repository
public interface RoleMenuMapper {

    /**
     * 新增角色菜单信息
     *
     * @param roleMenu
     * @return
     */
    @Insert("insert into r_role_and_menu(role_menu_id,role_code,org_id,menu_id,update_time) values(#{roleMenuId},#{roleCode},#{orgId},#{menuId},#{updateTime})")
    Integer insertRoleMenu(RoleMenu roleMenu);

    /**
     * 批量新增角色菜单信息
     *
     * @param roleMenuList
     */
    @Insert("<script>" +
            "insert into r_role_and_menu(role_menu_id,role_code,org_id,menu_id,update_time) values " +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.roleMenuId},#{item.roleCode},#{item.orgId},#{item.menuId},#{item.updateTime})" +
            "</foreach>" +
            "</script>")
    void insertRoleMenuBatch(@Param("list") List<RoleMenu> roleMenuList);

    /**
     * 修改角色菜单信息
     *
     * @param roleMenu
     * @return
     */
    @Update("update r_role_and_menu set role_code=#{roleCode},org_id=#{orgId},menu_id=#{menuId},update_time=#{updateTime} where role_menu_id=#{roleMenuId}")
    Integer updateRoleMenu(RoleMenu roleMenu);

    /**
     * 根据id查找角色菜单信息
     *
     * @param roleMenuId
     * @return
     */
    @Select("select * from r_role_and_menu where role_menu_id=#{roleMenuId}")
    RoleMenu getRoleMenuById(@Param("roleMenuId") Long roleMenuId);

    /**
     * 批量删除角色菜单信息
     *
     * @param roleMenuIds
     * @return
     */
    @Delete("<script>" +
            "delete from r_role_and_menu where role_menu_id in " +
            "<foreach collection='list' item='id' separator=',' open='(' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    Integer deleteRoleMenusByIds(@Param("list") List<Long> roleMenuIds);
}
