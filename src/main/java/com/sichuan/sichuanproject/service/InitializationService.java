package com.sichuan.sichuanproject.service;

import com.sichuan.sichuanproject.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 */

@Service
public interface InitializationService {
    /**
     * 初始化用户信息
     * 分页批量获取用户信息,并写入数据库
     *
     * @return
     */
    List<UserDTO> getQueryUserByPage();

    /**
     * 初始化部门信息
     * 分页获取部门信息，并写入数据库
     *
     * @return
     */
    List<OrganizationInfoDTO> getQueryOrganizationInfoByPage();

    /**
     * 初始化角色信息
     * 分页获取角色信息，并写入数据库
     *
     * @return
     */
    List<RoleDTO> getQueryRoleByPage();

    /**
     * 初始化用户角色信息
     * 分页获取用户角色信息，并写入数据库
     *
     * @return
     */
    List<UserRoleDTO> getQueryUserRoleByPage();

    /**
     * 初始化菜单信息
     * 分页获取菜单信息，并写入数据库
     *
     * @return
     */
    List<MenuInfoDTO> getQueryMenuInfoByPage();

    /**
     * 初始化角色菜单信息
     * 分页查询角色菜单信息，并写入数据库
     *
     * @return
     */
    List<RoleMenuDTO> getQueryRoleMenuInfoByPage();
}
