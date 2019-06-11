package com.sichuan.sichuanproject.controller;

import com.sichuan.sichuanproject.dto.*;
import com.sichuan.sichuanproject.service.InitializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author
 */

@CrossOrigin
@RestController
public class InitializationController {
    @Autowired
    private InitializationService initializationService;

    @RequestMapping(value = "/risk-warning/initialization/user", method = RequestMethod.GET)
    public List<UserDTO> getQueryUserByPage() {
        return initializationService.getQueryUserByPage();
    }

    @RequestMapping(value = "/risk-warning/initialization/organization", method = RequestMethod.GET)
    public List<OrganizationInfoDTO> getQueryOrganizationInfoByPage() {
        return initializationService.getQueryOrganizationInfoByPage();
    }

    @RequestMapping(value = "/risk-warning/initialization/role", method = RequestMethod.GET)
    public List<RoleDTO> getQueryRoleByPage() {
        return initializationService.getQueryRoleByPage();
    }

    @RequestMapping(value = "/risk-warning/initialization/user-role", method = RequestMethod.GET)
    public List<UserRoleDTO> getQueryUserRoleByPage() {
        return initializationService.getQueryUserRoleByPage();
    }

    @RequestMapping(value = "/risk-warning/initialization/menu", method = RequestMethod.GET)
    public List<MenuInfoDTO> getQueryMenuInfoByPage() {
        return initializationService.getQueryMenuInfoByPage();
    }

    @RequestMapping(value = "/risk-warning/initialization/role-menu", method = RequestMethod.GET)
    public List<RoleMenuDTO> getQueryRoleMenuInfoByPage() {
        return initializationService.getQueryRoleMenuInfoByPage();
    }
}
