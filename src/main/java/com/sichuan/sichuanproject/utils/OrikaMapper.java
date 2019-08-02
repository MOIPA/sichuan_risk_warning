package com.sichuan.sichuanproject.utils;

import com.sichuan.sichuanproject.domain.*;
import com.sichuan.sichuanproject.dto.AddTaskDTO;
import com.sichuan.sichuanproject.dto.StaRewiDTO;
import com.sichuan.sichuanproject.dto.WarningModelDTO;
import com.sichuan.sichuanproject.form.*;
import com.sichuan.sichuanproject.vo.MenuInfoVO;
import com.sichuan.sichuanproject.vo.OrganizationVO;
import com.sichuan.sichuanproject.vo.WarningModelVO;
import com.sichuan.sichuanproject.vo.WarningSignalVO;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaMapper {

    public OrikaMapper() {
    }

    private static MapperFactory mapperFactory;
    private static MapperFacade mapperFacade;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFacade = mapperFactory.getMapperFacade();
        mapperFactory.classMap(OrganizationVO.class, Organization.class);
        mapperFactory.classMap(WarningModel.class, WarningModelForm.class);
        mapperFactory.classMap(WarningModelDTO.class, WarningModelVO.class).field("id", "warningModelId")
                .byDefault().register();
        mapperFactory.classMap(Menu.class, MenuInfoVO.class).field("parentMenu", "parentMenuId")
                .byDefault().register();
//        mapperFactory.classMap(WarningSignalVO.class, StaRewiDTO.class).field("fxyjId","id")
//                .field("name","areaName")
//                .field("fxyjDomainId","")
//                .field("fxyjAreaNumber","areaCode")
//                .field("fxyjTitle","deptName")
//                .field("fxyjDesc","riskCount")
//                .field("fxyjLevel","riskLevel")
//                .field("fxyjTime","staData")
//                .field("fxyjModelId")
//                .field("fxyjDetailUrl")
//                .byDefault().register();
        mapperFactory.classMap(RiskFeatureBasicInfoForm.class, RiskFeatureBasicInfo.class);
        mapperFactory.classMap(DangerousChemicalForm.class, DangerousChemical.class);
        mapperFactory.classMap(WarningModelRuleForm.class, WarningModelRule.class);
        mapperFactory.classMap(AddTaskForm.class, AddTaskDTO.class);

    }

    public static Object map(Object from, Class<?> to) {
        return mapperFacade.map(from, to);
    }

}
