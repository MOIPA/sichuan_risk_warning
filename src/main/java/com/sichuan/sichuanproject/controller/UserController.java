package com.sichuan.sichuanproject.controller;

import com.sichuan.sichuanproject.dto.UserAccessTokenDTO;
import com.sichuan.sichuanproject.dto.UserInfoDTO;
import com.sichuan.sichuanproject.service.UserService;
import com.sichuan.sichuanproject.vo.MenuInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @author
 */

@CrossOrigin
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/risk-warning/user-menu", method = RequestMethod.GET)
    public List<MenuInfoVO> getMenuByUser(@RequestParam(value = "code") String code) {
        try {
            UserAccessTokenDTO userAccessTokenDTO = userService.getAccessToken(code);
            UserInfoDTO userInfoDTO = userService.getUserInfo(userAccessTokenDTO.getAccess_token());

            Long userId = Long.valueOf(userInfoDTO.getUuid());
            Long orgId = Long.valueOf(userInfoDTO.getOrgId());

            return userService.getMenuInfoByUser(userId, orgId);

        }catch (Exception e) {
            log.error(e.getMessage());
            return new ArrayList<>();
        }
    }
}
