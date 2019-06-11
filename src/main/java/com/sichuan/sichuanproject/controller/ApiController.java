package com.sichuan.sichuanproject.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.sichuan.sichuanproject.config.DataChangeNoticeType;
import com.sichuan.sichuanproject.dto.*;
import com.sichuan.sichuanproject.form.DataChangeNoticeForm;
import com.sichuan.sichuanproject.form.TaskStatusForm;
import com.sichuan.sichuanproject.service.OrganizationService;
import com.sichuan.sichuanproject.service.TaskService;
import com.sichuan.sichuanproject.service.UserService;
import javafx.concurrent.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */

@CrossOrigin
@RestController
@Slf4j
public class ApiController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private TaskService taskService;

    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/risk-warning/data-change-notice", method = RequestMethod.POST)
    public Integer dataChangeNotice(@RequestBody DataChangeNoticeForm dataChangeNoticeForm) {
        Integer type = dataChangeNoticeForm.getType();
        String operaType = dataChangeNoticeForm.getOprateType();
        List<Object> data = dataChangeNoticeForm.getData();
        if (type.equals(DataChangeNoticeType.USER_INFO.value())) {
            //同步用户信息
            List<UserDTO> userDTOList = new ArrayList<>();
            try {
                for (Object o : data) {
                    String str = mapper.writeValueAsString(o);
                    UserDTO userDTO = mapper.readValue(str, UserDTO.class);
                    userDTOList.add(userDTO);
                }
            }catch (Exception e) {
                log.error("同步用户信息失败: " + e.getMessage());
            }

            return userService.userChangeNotice(operaType, userDTOList);

        }else if (type.equals(DataChangeNoticeType.ACCOUNT_INFO.value())) {
            //同步账户信息
            return 0;
        }else if (type.equals(DataChangeNoticeType.USER_ROLE_INFO.value())) {
            //同步用户角色信息
            List<UserRoleDTO> userRoleDTOList = new ArrayList<>();
            try {
                for (Object o : data) {
                    String str = mapper.writeValueAsString(o);
                    UserRoleDTO userRoleDTO = mapper.readValue(str, UserRoleDTO.class);
                    userRoleDTOList.add(userRoleDTO);
                }
            }catch (Exception e) {
                log.error("同步用户角色消息失败： " + e.getMessage());
            }
            return userService.userRoleChangeNotice(operaType, userRoleDTOList);
        }else if (type.equals(DataChangeNoticeType.ROLE_INFO.value())) {
            //同步角色信息
            List<RoleDTO> roleDTOList = new ArrayList<>();
            try {
                for (Object o : data) {
                    String str = mapper.writeValueAsString(o);
                    RoleDTO roleDTO = mapper.readValue(str, RoleDTO.class);
                    roleDTOList.add(roleDTO);
                }
            }catch (Exception e) {
                log.error("同步角色信息失败: " + e.getMessage());
            }

            return userService.roleChangeNotice(operaType, roleDTOList);
        }else if (type.equals(DataChangeNoticeType.ROLE_MENU_INFO.value())) {
            //同步角色菜单信息
            List<RoleMenuDTO> roleMenuDTOList = new ArrayList<>();
            try {
                for (Object o : data) {
                    String str = mapper.writeValueAsString(o);
                    RoleMenuDTO roleMenuDTO = mapper.readValue(str, RoleMenuDTO.class);
                    roleMenuDTOList.add(roleMenuDTO);
                }
            }catch (Exception e) {
                log.error("同步角色菜单信息失败: " + e.getMessage());
            }
            return userService.roleMenuChangeNotice(operaType, roleMenuDTOList);
        }else if (type.equals(DataChangeNoticeType.MENU_INFO)) {
            //同步菜单信息
            List<MenuInfoDTO> menuInfoDTOList = new ArrayList<>();
            try {
                for (Object o : data) {
                    String str = mapper.writeValueAsString(o);
                    MenuInfoDTO menuInfoDTO = mapper.readValue(str, MenuInfoDTO.class);
                    menuInfoDTOList.add(menuInfoDTO);
                }
            }catch (Exception e) {
                log.error("同步菜单信息失败: " + e.getMessage());
            }
            return userService.menuChangeNotice(operaType, menuInfoDTOList);
        }else if (type.equals(DataChangeNoticeType.AREA_INFO.value())) {
            //同步区域信息
            return 0;
        }else if (type.equals(DataChangeNoticeType.ORG_INFO.value())) {
            //同步部门信息
            List<OrganizationInfoDTO> organizationInfoDTOList = new ArrayList<>();
            try {
                for (Object o : data) {
                    String str = mapper.writeValueAsString(o);
                    OrganizationInfoDTO organizationInfoDTO = mapper.readValue(str, OrganizationInfoDTO.class);
                    organizationInfoDTOList.add(organizationInfoDTO);
                }
            }catch (Exception e) {
                log.error("同步部门信息失败: " + e.getMessage());
            }

            return organizationService.organizationChangeNotice(operaType, organizationInfoDTOList);
        }

        return 1;
    }

    @RequestMapping(value = "/risk-warning/task-status-notice", method = RequestMethod.POST)
    public TaskStatusFallBackDTO taskStatusNotice(@RequestBody TaskStatusForm taskStatusForm) {
        return taskService.noticeTaskStatus(taskStatusForm);
    }
}
