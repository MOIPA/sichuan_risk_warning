package com.sichuan.sichuanproject.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sichuan.sichuanproject.config.OperationType;
import com.sichuan.sichuanproject.domain.*;
import com.sichuan.sichuanproject.dto.*;
import com.sichuan.sichuanproject.mapper.primary.*;
import com.sichuan.sichuanproject.service.UserService;
import com.sichuan.sichuanproject.utils.OrikaMapper;
import com.sichuan.sichuanproject.vo.MenuInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author
 */

@Component
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    static String userServiceUrl = "http://59.225.206.13:5049/user-service-center";

    static String secret = "Q3oe01gWYqVqY27E";

    static String salt = "4xA1A4ipY77ZiywI";

    @Override
    public Integer userChangeNotice(String operaType, List<UserDTO> userDTOList) {

        Integer result = 1;

        if (operaType.equals(OperationType.CHANGE.value())) {

            Integer num = 0;

            for (UserDTO userDTO : userDTOList) {
                User user;
                user = userMapper.getUserById(userDTO.getUserId());
                if (user == null) {
                    //用户不存在，新增用户
                    User newUser = new User(userDTO.getUserId(), userDTO.getUserName(), userDTO.getOrgId(), userDTO.getBirthAddress(), userDTO.getAddress(), userDTO.getMobile(), userDTO.getIdCode(), userDTO.getUpdateTime());
                    num += userMapper.insertUser(newUser);
                }else {
                    //用户存在，修改用户
                    User updateUser = new User(userDTO.getUserId(), userDTO.getUserName(), userDTO.getOrgId(), userDTO.getBirthAddress(), userDTO.getAddress(), userDTO.getMobile(), userDTO.getIdCode(), userDTO.getUpdateTime());
                    num += userMapper.updateUser(updateUser);
                }
            }

            if (num > 0) {
                result = 0;
            }

        }else if (operaType.equals(OperationType.DELETE.value())) {
            List<Long> userIds = new ArrayList<>();
            userDTOList.forEach((e) ->
                userIds.add(e.getUserId())
            );
            Integer num = userMapper.deleteUsersByIds(userIds);
            if (num > 0) {
                result = 0;
            }
        }
        return result;
    }

    @Override
    public Integer roleChangeNotice(String operaType, List<RoleDTO> roleDTOList) {
        Integer result = 1;

        if (operaType.equals(OperationType.CHANGE.value())) {
            Integer num = 0;

            for (RoleDTO roleDTO : roleDTOList) {
                Role role = new Role();
                role = roleMapper.getRoleById(roleDTO.getRoleCode());
                if (role == null) {
                    //角色不存在，新增角色
                    Role newRole = new Role(roleDTO.getRoleCode(), roleDTO.getRoleName(), roleDTO.getRoleDesc(), roleDTO.getValidStatus(), roleDTO.getUpdateTime());
                    num += roleMapper.insertRole(newRole);
                }else {
                    //角色存在，修改角色
                    Role updateRole = new Role(roleDTO.getRoleCode(), roleDTO.getRoleName(), roleDTO.getRoleDesc(), roleDTO.getValidStatus(), roleDTO.getUpdateTime());
                    num += roleMapper.updateRole(updateRole);
                }
            }

            if (num >0 ) {
                result = 0;
            }

        }else if (operaType.equals(OperationType.DELETE.value())) {
            List<Long> roleCodes = new ArrayList<>();
            roleDTOList.forEach((e) ->
                roleCodes.add(e.getRoleCode())
            );
            Integer num = roleMapper.deleteRoles(roleCodes);
            if (num > 0) {
                result = 0;
            }
        }

        return result;
    }

    @Override
    public Integer menuChangeNotice(String operaType, List<MenuInfoDTO> menuInfoDTOList) {
        Integer result = 1;

        if (operaType.equals(OperationType.CHANGE.value())) {
            Integer num = 0;

            for (MenuInfoDTO menuInfoDTO : menuInfoDTOList) {
                Menu menu;
                menu = menuMapper.getMenuById(menuInfoDTO.getMenuId());
                if (menu == null) {
                    //菜单不存在，新增菜单
                    Menu newMenu = new Menu(menuInfoDTO.getMenuId(), menuInfoDTO.getMenuName(), menuInfoDTO.getMenuType(), menuInfoDTO.getMenuContent(), menuInfoDTO.getParentMenu(), menuInfoDTO.getOrderNum(), menuInfoDTO.getAppCode(), menuInfoDTO.getUpdateTime());
                    num += menuMapper.insertMenu(newMenu);
                }else {
                    //菜单存在，修改菜单
                    Menu updateMenu = new Menu(menuInfoDTO.getMenuId(), menuInfoDTO.getMenuName(), menuInfoDTO.getMenuType(), menuInfoDTO.getMenuContent(), menuInfoDTO.getParentMenu(), menuInfoDTO.getOrderNum(), menuInfoDTO.getAppCode(), menuInfoDTO.getUpdateTime());
                    num += menuMapper.updateMenu(updateMenu);
                }
            }

            if (num > 0) {
                result = 0;
            }

        }else if (operaType.equals(OperationType.DELETE.value())) {
            List<Long> menuIds = new ArrayList<>();
            menuInfoDTOList.forEach((e) ->
                menuIds.add(e.getMenuId())
            );
            Integer num = menuMapper.deleteMenusByIds(menuIds);
            if (num > 0) {
                result = 0;
            }
        }

        return result;
    }

    @Override
    public Integer userRoleChangeNotice(String operaType, List<UserRoleDTO> userRoleDTOList) {
        Integer result = 1;

        if (operaType.equals(OperationType.CHANGE.value())) {
            Integer num = 0;

            for (UserRoleDTO userRoleDTO : userRoleDTOList) {
                UserRole userRole = new UserRole();
                userRole = userRoleMapper.getUserRoleById(userRoleDTO.getUserId(), userRoleDTO.getOrgId());
                if (userRole == null) {
                    //用户角色不存在，新增用户角色
                    UserRole newUserRole = new UserRole(userRoleDTO.getUserId(), userRoleDTO.getOrgId(), userRoleDTO.getRoleCode(), userRoleDTO.getUpdateTime());
                    num += userRoleMapper.insertUserRole(newUserRole);
                }else {
                    //用户角色存在，修改用户角色
                    UserRole updateUserRole = new UserRole(userRoleDTO.getUserId(), userRoleDTO.getOrgId(), userRoleDTO.getRoleCode(), userRoleDTO.getUpdateTime());
                    num += userRoleMapper.updateUserRole(updateUserRole);
                }
            }
            if (num > 0) {
                result = 0;
            }

        }else if (operaType.equals(OperationType.DELETE.value())) {
            Integer num = 0;
            for (UserRoleDTO userRoleDTO : userRoleDTOList) {
                num += userRoleMapper.deleteUserRoleById(userRoleDTO.getUserId(), userRoleDTO.getOrgId());
            }
            if (num > 0) {
                result = 0;
            }
        }


        return result;
    }

    @Override
    public Integer roleMenuChangeNotice(String operaType, List<RoleMenuDTO> roleMenuDTOList) {
        Integer result = 1;

        if (operaType.equals(OperationType.CHANGE.value())) {
            Integer num = 0;

            for (RoleMenuDTO roleMenuDTO : roleMenuDTOList) {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu = roleMenuMapper.getRoleMenuById(roleMenuDTO.getRoleMenuId());

                if (roleMenu == null) {
                    //角色菜单不存在，新增
                    RoleMenu newRoleMenu = new RoleMenu(roleMenuDTO.getRoleMenuId(), roleMenuDTO.getRoleCode(), roleMenuDTO.getOrgId(), roleMenuDTO.getMenuId(), roleMenuDTO.getUpdateTime());
                    num += roleMenuMapper.insertRoleMenu(newRoleMenu);
                }else {
                    //角色菜单存在，修改
                    RoleMenu updateRoleMenu = new RoleMenu(roleMenuDTO.getRoleMenuId(), roleMenuDTO.getRoleCode(), roleMenuDTO.getOrgId(), roleMenuDTO.getMenuId(), roleMenuDTO.getUpdateTime());
                    num += roleMenuMapper.updateRoleMenu(updateRoleMenu);
                }
            }

            if (num > 0) {
                result = 0;
            }

        }else if (operaType.equals(OperationType.DELETE.value())) {
            List<Long> roleMenuIds = new ArrayList<>();
            roleMenuDTOList.forEach((e) ->
                roleMenuIds.add(e.getRoleMenuId())
            );
            Integer num = roleMenuMapper.deleteRoleMenusByIds(roleMenuIds);
            if (num > 0) {
                result = 0;
            }
        }

        return result;
    }

    @Override
    public UserAccessTokenDTO getAccessToken(String code) {
        UserAccessTokenDTO userAccessTokenDTO = restTemplate.getForObject(userServiceUrl + "/oauth/accessToken?grant_type=authorization_code&client_id=10006&client_sercret=1549e1ce6606c4aa4e745f17e70b3098&code=" + code, UserAccessTokenDTO.class);

        return userAccessTokenDTO;
    }

    @Override
    public UserAccessTokenDTO refreshAccessToken(String refreshToken) {
        UserAccessTokenDTO userAccessTokenDTO = restTemplate.getForObject(userServiceUrl + "/oauth/refreshAccessToken?grant_type=refresh_token&client_id=10006&client_sercret=1549e1ce6606c4aa4e745f17e70b3098&refresh_token=" + refreshToken, UserAccessTokenDTO.class);

        return userAccessTokenDTO;
    }

    @Override
    public UserInfoDTO getUserInfo(String accessToken) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        String text = restTemplate.getForObject(userServiceUrl + "/oauth/userInfo?client_id=10006&client_sercret=1549e1ce6606c4aa4e745f17e70b3098&access_token=" + accessToken, String.class);
        String result = null;
        try {
            result = decrypt(secret, salt, text);
        }catch (Exception e) {
            log.error("1:" + e.getMessage());
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            userInfoDTO = mapper.readValue(result, UserInfoDTO.class);
        }catch (Exception e) {
            log.error("2:" + e.getMessage());
        }

        return userInfoDTO;
    }

    @Override
    public List<MenuInfoVO> getMenuInfoByUser(Long userId, Long orgId) {
        return userMapper.getMenuByUserId(userId, orgId)
                .stream().map(e -> (MenuInfoVO) OrikaMapper.map(e, MenuInfoVO.class)).collect(Collectors.toList());

    }

    private String decrypt(String secret, String salt, String ciphertext ) throws Exception {

        SecretKeySpec skeySpec = new SecretKeySpec(secret.getBytes("ASCII"), "AES");

        IvParameterSpec iv = new IvParameterSpec(salt.getBytes());

        // 先用base64解密
        byte[] base64Decrypted = Base64.decodeBase64(ciphertext.getBytes());

        // 解密
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] plainTextBytes = cipher.doFinal(base64Decrypted);

        return new String(plainTextBytes, "utf-8");
    }
}
