package com.sichuan.sichuanproject.utils;

import com.sichuan.sichuanproject.domain.WarningModel;
import com.sichuan.sichuanproject.form.WarningModelForm;
import com.sichuan.sichuanproject.vo.WarningModelVO;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaMapper {
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    public void configure() {
        mapperFactory.classMap(WarningModelForm.class, WarningModel.class).byDefault().register();
        mapperFactory.classMap(WarningModel.class, WarningModelVO.class).field("id","warningModelId").byDefault().register();
    }
}
