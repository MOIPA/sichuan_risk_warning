package com.sichuan.sichuanproject.service;

import com.sichuan.sichuanproject.dto.*;
import com.sichuan.sichuanproject.vo.MenuInfoVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 */

@Service
public interface UserService {

    /**
     * 用户修改的信息通知
     * operaType = C : 用户增加或者修改
     * operaType = D : 用户删除
     *
     * @param operaType
     * @param userDTOList
     * @return
     */
    Integer userChangeNotice(String operaType, List<UserDTO> userDTOList);

    /**
     * 角色修改的消息通知
     * operaType = C : 角色增加或者修改
     * operaType = D : 角色删除
     *
     * @param operaType
     * @param roleDTOList
     * @return
     */
    Integer roleChangeNotice(String operaType, List<RoleDTO> roleDTOList);

    /**
     * 菜单修改的消息通知
     *
     * @param operaType
     * @param menuInfoDTOList
     * @return
     */
    Integer menuChangeNotice(String operaType, List<MenuInfoDTO> menuInfoDTOList);

    /**
     * 用户角色修改的消息通知
     *
     * @param operaType
     * @param userRoleDTOList
     * @return
     */
    Integer userRoleChangeNotice(String operaType, List<UserRoleDTO> userRoleDTOList);

    /**
     * 角色菜单修改的消息通知
     *
     * @param operaType
     * @param roleMenuDTOList
     * @return
     */
    Integer roleMenuChangeNotice(String operaType, List<RoleMenuDTO> roleMenuDTOList);

    /**
     * 获取accessToken
     *
     * @param code
     * @return
     */
    UserAccessTokenDTO getAccessToken(String code);

    /**
     * 刷新accessToken
     *
     * @param refreshToken
     * @return
     */
    UserAccessTokenDTO refreshAccessToken(String refreshToken);

    /**
     * 获取用户信息
     *
     * @param accessToken
     * @return
     */
    UserInfoDTO getUserInfo(String accessToken);

    /**
     * 获取用户的可用菜单
     *
     * @param userId
     * @param orgId
     * @return
     */
    List<MenuInfoVO> getMenuInfoByUser(Long userId, Long orgId);
}
