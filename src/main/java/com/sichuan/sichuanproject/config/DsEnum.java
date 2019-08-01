package com.sichuan.sichuanproject.config;

/**
 * @author: tr
 * @Date: 2019-8-01
 * @Description:数据库枚举类型，存放数据库标识
 */
public enum DsEnum {
    /**
     * 数据库枚举
     */
    FIRST_DS("firstDataSource","001","first数据库"),
    SECOND_DS("secondDataSource","002","second数据库"),
    AUTO_DS("auto","003","预留字段后期自动获取数据库"),
    NONE("error","999","BASE ERROR")
            ;

    private String ds;
    private String baseid;
    private String message;

    public static DsEnum createDSBybaseid(String cid) {
        for(DsEnum val : DsEnum.values()) {
            if(val.getBaseid().equalsIgnoreCase(cid)) {
                return val;
            }
        }
        return DsEnum.NONE;
    }

    DsEnum(String ds, String baseid) {
        this.ds = ds;
        this.baseid = baseid;
    }

    DsEnum(String ds, String baseid, String message) {
        this.ds = ds;
        this.baseid = baseid;
        this.message = message;
    }

    public String getDs() {
        return ds;
    }

    public String getBaseid() {
        return baseid;
    }

    public String getMessage() {
        return message;
    }


}
