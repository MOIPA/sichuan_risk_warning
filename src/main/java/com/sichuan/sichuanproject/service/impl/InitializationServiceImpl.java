package com.sichuan.sichuanproject.service.impl;

import com.sichuan.sichuanproject.domain.*;
import com.sichuan.sichuanproject.dto.*;
import com.sichuan.sichuanproject.mapper.*;
import com.sichuan.sichuanproject.service.InitializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */

@Component
public class InitializationServiceImpl implements InitializationService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    static String userServiceUrl = "http://59.225.206.13:5049/user-service-center";

    @Override
    public List<UserDTO> getQueryUserByPage() {
        List<UserDTO> userDTOList = new ArrayList<>();
        UserDTO[] userDTOS;
        int page = 1;
        do {
            userDTOS = restTemplate.getForObject(userServiceUrl + "/query/queryUserByPage?client_id=10006&client_sercret=1549e1ce6606c4aa4e745f17e70b3098&page=" + page + "&pagesize=100", UserDTO[].class);
            for (UserDTO userDTO : userDTOS) {
                userDTOList.add(userDTO);
            }
            page += 1;
        }while (userDTOS.length == 100);

        List<User> userList = new ArrayList<>();
        userDTOList.forEach((e) ->{
            User user = new User(e.getUserId(), e.getUserName(), e.getOrgId(), e.getBirthAddress(), e.getAddress(), e.getMobile(), e.getIdCode(), e.getUpdateTime());
            userList.add(user);
        });
        userMapper.insertUserInfoBatch(userList);


        return userDTOList;
    }

    @Override
    public List<OrganizationInfoDTO> getQueryOrganizationInfoByPage() {
        List<OrganizationInfoDTO> organizationInfoDTOList = new ArrayList<>();
        OrganizationInfoDTO[] organizationInfoDTOS;
        int page = 1;
        do {
            organizationInfoDTOS = restTemplate.getForObject(userServiceUrl + "/query/queryOrganizaitonPage?client_id=10006&client_sercret=1549e1ce6606c4aa4e745f17e70b3098&page=" + page + "&pagesize=10000", OrganizationInfoDTO[].class);
            for (OrganizationInfoDTO organizationInfoDTO : organizationInfoDTOS) {
                organizationInfoDTOList.add(organizationInfoDTO);
            }
            page += 1;
        }while (organizationInfoDTOS.length == 10000);

        List<Organization> organizationList = new ArrayList<>();
        organizationInfoDTOList.forEach((e) ->{
            Organization organization = new Organization(e.getOrgId(), e.getOrgCode(), e.getOrgName(), e.getAreaCode(), e.getShortName(), e.getParentOrg(), e.getIsDelete(), e.getUpdateTime(), e.getIsParent());
            organizationList.add(organization);
        });
        organizationMapper.insertOrganizationInfoBatch(organizationList);

        return organizationInfoDTOList;
    }

    @Override
    public List<RoleDTO> getQueryRoleByPage() {
        List<RoleDTO> roleDTOList = new ArrayList<>();
        RoleDTO[] roleDTOS;
        int page = 1;
        do {
            roleDTOS = restTemplate.getForObject(userServiceUrl + "/query/queryRoleByPage?client_id=10006&client_sercret=1549e1ce6606c4aa4e745f17e70b3098&page=" + page + "&pagesize=100", RoleDTO[].class);
            for (RoleDTO roleDTO : roleDTOS) {
                roleDTOList.add(roleDTO);
            }
            page += 1;
        }while (roleDTOS.length == 100);

        List<Role> roleList = new ArrayList<>();
        roleDTOList.forEach((e) ->{
            Role role = new Role(e.getRoleCode(), e.getRoleName(), e.getRoleDesc(), e.getValidStatus(), e.getUpdateTime());
            roleList.add(role);
        });
        roleMapper.insertRoleBatch(roleList);


        return roleDTOList;
    }

    @Override
    public List<UserRoleDTO> getQueryUserRoleByPage() {
        List<UserRoleDTO> userRoleDTOList = new ArrayList<>();
        UserRoleDTO[] userRoleDTOS;
        int page = 1;
        do {
            userRoleDTOS = restTemplate.getForObject(userServiceUrl + "/query/queryUserRoleByPage?client_id=10006&client_sercret=1549e1ce6606c4aa4e745f17e70b3098&page=" + page + "&pagesize=100", UserRoleDTO[].class);
            for (UserRoleDTO userRoleDTO : userRoleDTOS) {
                userRoleDTOList.add(userRoleDTO);
            }
            page += 1;
        }while (userRoleDTOS.length == 100);

        List<UserRole> userRoleList = new ArrayList<>();
        userRoleDTOList.forEach((e) ->{
            UserRole userRole = new UserRole();
            userRole.setUserId(e.getUserId());
            userRole.setRoleCode(e.getRoleCode());
            userRole.setOrgId(e.getOrgId());
            userRole.setUpdateTime(e.getUpdateTime());

            userRoleList.add(userRole);
        });
        userRoleMapper.insertUserRoleBatch(userRoleList);

        return userRoleDTOList;
    }

    @Override
    public List<MenuInfoDTO> getQueryMenuInfoByPage() {
        List<MenuInfoDTO> menuInfoDTOList = new ArrayList<>();
        MenuInfoDTO[] menuInfoDTOS;
        int page = 1;
        do {
            menuInfoDTOS = restTemplate.getForObject(userServiceUrl + "/query/queryMenuInfoByPage?client_id=10006&client_sercret=1549e1ce6606c4aa4e745f17e70b3098&page=" + page + "&pagesize=100", MenuInfoDTO[].class);
            for (MenuInfoDTO menuInfoDTO : menuInfoDTOS) {
                menuInfoDTOList.add(menuInfoDTO);
            }
            page += 1;
        }while (menuInfoDTOS.length == 100);

        List<Menu> menuList = new ArrayList<>();
        menuInfoDTOList.forEach((e) ->{
            Menu menu = new Menu(e.getMenuId(), e.getMenuName(), e.getMenuType(), e.getMenuContent(), e.getParentMenu(), e.getOrderNum(), e.getAppCode(), e.getUpdateTime());
            menuList.add(menu);
        });
        menuMapper.insertMenuBatch(menuList);

        return menuInfoDTOList;
    }

    @Override
    public List<RoleMenuDTO> getQueryRoleMenuInfoByPage() {
        List<RoleMenuDTO> roleMenuDTOList = new ArrayList<>();
        RoleMenuDTO[] roleMenuDTOS;
        int page = 1;
        do {
            roleMenuDTOS = restTemplate.getForObject(userServiceUrl + "/query/queryRoleMenuInfoByPage?client_id=10006&client_sercret=1549e1ce6606c4aa4e745f17e70b3098&page=" + page +"&pagesize=100", RoleMenuDTO[].class);
            for (RoleMenuDTO roleMenuDTO : roleMenuDTOS) {
                roleMenuDTOList.add(roleMenuDTO);
            }
            page += 1;
        }while (roleMenuDTOS.length == 100);

        List<RoleMenu> roleMenuList = new ArrayList<>();
        roleMenuDTOList.forEach((e) ->{
            RoleMenu roleMenu = new RoleMenu(e.getRoleMenuId(), e.getRoleCode(), e.getOrgId(), e.getMenuId(), e.getUpdateTime());
            roleMenuList.add(roleMenu);
        });
        roleMenuMapper.insertRoleMenuBatch(roleMenuList);

        return roleMenuDTOList;
    }

}
