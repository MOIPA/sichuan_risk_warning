package com.sichuan.sichuanproject.utils;

import com.sichuan.sichuanproject.domain.Menu;
import com.sichuan.sichuanproject.domain.Organization;
import com.sichuan.sichuanproject.domain.WarningModel;
import com.sichuan.sichuanproject.dto.WarningModelDTO;
import com.sichuan.sichuanproject.form.WarningModelForm;
import com.sichuan.sichuanproject.vo.MenuInfoVO;
import com.sichuan.sichuanproject.vo.OrganizationVO;
import com.sichuan.sichuanproject.vo.WarningModelVO;
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

    }

    public static Object map(Object from, Class<?> to) {
        return mapperFacade.map(from, to);
    }

}
