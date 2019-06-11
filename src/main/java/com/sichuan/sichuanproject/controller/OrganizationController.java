package com.sichuan.sichuanproject.controller;

import com.sichuan.sichuanproject.service.OrganizationService;
import com.sichuan.sichuanproject.vo.OrganizationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author
 */

@CrossOrigin
@RestController
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/risk-warning/organization-info/get", method = RequestMethod.GET)
    public List<OrganizationVO> getOrganizationInfo() {
        return organizationService.getOrganizationInfo();
    }

    @RequestMapping(value = "/risk-warning/organization-info/get/name", method = RequestMethod.GET)
    public List<OrganizationVO> getOrganizationInfoByName(@RequestParam(value = "name") String name) {
        return organizationService.getOrganizationInfoByName(name);
    }
}
