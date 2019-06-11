package com.sichuan.sichuanproject.form;

import lombok.Data;

import java.util.List;

/**
 * @author
 */

@Data
public class DataChangeNoticeForm {
    private Integer type;
    private String oprateType;
    private List<Object> data;
}
