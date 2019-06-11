package com.sichuan.sichuanproject.service;

import com.sichuan.sichuanproject.dto.OrganizationInfoDTO;
import com.sichuan.sichuanproject.vo.OrganizationVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 */

@Service
public interface OrganizationService {

    /**
     * 部门信息修改的通知
     * operaType = C : 部门添加或者修改
     * operaType = D : 部门删除
     *
     * @param operaType
     * @param organizationInfoDTOList
     * @return
     */
    Integer organizationChangeNotice(String operaType, List<OrganizationInfoDTO> organizationInfoDTOList);

    /**
     * 获取部门信息
     *
     * @return
     */
    List<OrganizationVO> getOrganizationInfo();

    /**
     * 根据名称获取部门信息
     *
     * @param name
     * @return
     */
    List<OrganizationVO> getOrganizationInfoByName(String name);
}
