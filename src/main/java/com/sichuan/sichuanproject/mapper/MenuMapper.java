package com.sichuan.sichuanproject.mapper;

import com.sichuan.sichuanproject.domain.Menu;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 */

@Mapper
@Repository
public interface MenuMapper {

    /**
     * 新增菜单
     *
     * @param menu
     * @return
     */
    @Insert("insert into menu_info(menu_id,menu_name,menu_type,menu_content,parent_menu,order_num,app_code,update_time) values(#{menuId},#{menuName},#{menuType},#{menuContent},#{parentMenu},#{orderNum},#{appCode},#{updateTime})")
    Integer insertMenu(Menu menu);

    /**
     * 批量插入菜单信息
     *
     * @param menuList
     */
    @Insert("<script>" +
            "insert into menu_info(menu_id,menu_name,menu_type,menu_content,parent_menu,order_num,app_code,update_time) values " +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.menuId},#{item.menuName},#{item.menuType},#{item.menuContent},#{item.parentMenu},#{item.orderNum},#{item.appCode},#{item.updateTime})" +
            "</foreach>" +
            "</script>")
    void insertMenuBatch(@Param("list") List<Menu> menuList);

    /**
     * 修改菜单信息
     *
     * @param menu
     * @return
     */
    @Update("update menu_info set menu_name=#{menuName},menu_type=#{menuType},menu_content=#{menuContent},parent_menu=#{parentMenu},order_num=#{orderNum},app_code=#{appCode},update_time=#{updateTime} where menu_id=#{menuId}")
    Integer updateMenu(Menu menu);

    /**
     * 批量删除菜单
     *
     * @param menuIds
     * @return
     */
    @Delete("<script>" +
            "delete from menu_info where menu_id in " +
            "<foreach collection='list' item='id' separator=',' open='(' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    Integer deleteMenusByIds(@Param("list") List<Long> menuIds);

    /**
     * 根据menuId查找菜单信息
     *
     * @param menuId
     * @return
     */
    @Select("select * from menu_info where menu_id=#{menuId}")
    Menu getMenuById(Long menuId);
}
