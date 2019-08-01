package com.sichuan.sichuanproject.service.impl;

import com.sichuan.sichuanproject.config.OperationType;
import com.sichuan.sichuanproject.domain.Organization;
import com.sichuan.sichuanproject.dto.OrganizationInfoDTO;
import com.sichuan.sichuanproject.mapper.primary.OrganizationMapper;
import com.sichuan.sichuanproject.service.OrganizationService;
import com.sichuan.sichuanproject.utils.OrikaMapper;
import com.sichuan.sichuanproject.vo.OrganizationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */

@Component
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;


    @Override
    public Integer organizationChangeNotice(String operaType, List<OrganizationInfoDTO> organizationInfoDTOList) {
        Integer result = 1;

        if (operaType.equals(OperationType.CHANGE.value())) {
            Integer num = 0;
            for (OrganizationInfoDTO organizationInfoDTO : organizationInfoDTOList) {
                Organization organization = new Organization();
                organization = organizationMapper.getOrganizationInfoById(organizationInfoDTO.getOrgId());
                if (organization == null) {
                    //部门不存在，新增部门
                    Organization newOrganization = new Organization(organizationInfoDTO.getOrgId(), organizationInfoDTO.getOrgCode(), organizationInfoDTO.getOrgName(), organizationInfoDTO.getAreaCode(), organizationInfoDTO.getShortName(), organizationInfoDTO.getParentOrg(), organizationInfoDTO.getIsDelete(), organizationInfoDTO.getUpdateTime(), organizationInfoDTO.getIsParent());
                    num += organizationMapper.insertOrganizationInfo(newOrganization);
                }else {
                    //部门存在，修改部门信息
                    Organization updateOrganization = new Organization(organizationInfoDTO.getOrgId(), organizationInfoDTO.getOrgCode(), organizationInfoDTO.getOrgName(), organizationInfoDTO.getAreaCode(), organizationInfoDTO.getShortName(), organizationInfoDTO.getParentOrg(), organizationInfoDTO.getIsDelete(), organizationInfoDTO.getUpdateTime(), organizationInfoDTO.getIsParent());
                    num += organizationMapper.updateOrganizationInfo(updateOrganization);
                }
            }

            if (num > 0) {
                result = 0;
            }

        }else if (operaType.equals(OperationType.DELETE.value())) {
            List<Long> orgIds = new ArrayList<>();
            organizationInfoDTOList.forEach((e) ->
                orgIds.add(e.getOrgId())
            );
            Integer num = organizationMapper.deleteOrganizationsByIds(orgIds);
            if (num > 0) {
                result = 0;
            }
        }

        return result;
    }

    @Override
    public List<OrganizationVO> getOrganizationInfo() {
        List<OrganizationVO> organizationVOList = new ArrayList<>();
        List<Organization> organizationList = organizationMapper.getOrganizationInfo();

        organizationList.forEach(e -> organizationVOList.add((OrganizationVO) OrikaMapper.map(e, OrganizationVO.class)));

        return organizationVOList;
    }

    @Override
    public List<OrganizationVO> getOrganizationInfoByName(String name) {
        List<OrganizationVO> organizationVOList = new ArrayList<>();
        List<Organization> organizationList = organizationMapper.getOrganizationInfoByName(name);

        organizationList.forEach(e -> organizationVOList.add((OrganizationVO) OrikaMapper.map(e, OrganizationVO.class)));

        return organizationVOList;
    }
}
