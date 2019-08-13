package com.sichuan.sichuanproject.mapper.second;

import com.sichuan.sichuanproject.domain.WarningSignal;
import com.sichuan.sichuanproject.dto.StaRewiDTO;
import com.sichuan.sichuanproject.vo.WarningSignalVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 */

@Mapper
@Repository
public interface StaRewiMapper {


    /**
     * 查询需要推送数据
     *
     * @return
     */
    @Select("select area_code,t1.id,t1.area_name,t1.dept_name,dept_code,risk_level,count(risk_level) risk_count,risk_field,sta_data from\n" +
            "(select\n" +
            "ws.Fxyj_Id id,\n" +
            "ws.Fxyj_Area_Number area_code,\n" +
            "ws.Fxyj_Area_Name area_name,\n" +
            "wm.org_code dept_code,\n" +
            "oi.org_name dept_name,\n" +
            "ws.Fxyj_Level risk_level,\n" +
            "ws.Fxyj_Domain_Id risk_field,\n" +
            "ws.Fxyj_Time sta_data\n" +
            "\n" +
            "from JG_FXYJ_WARNING_SIGNAL ws,warning_model wm,organization_info oi\n" +
            "where ws.Fxyj_Model_Id=wm.id and oi.org_code=wm.org_code) as t1\n" +
            "\n" +
            "group by area_code,dept_code,sta_data,risk_level,risk_field;")
    List<StaRewiDTO> getPushData();


    /**
     * 推送数据
     */
    @Insert("insert into sta_rewi_data" +
            "(id,area_code,area_name,dept_code,dept_name,risk_count,risk_level,risk_field,sta_data,FXYJXT) " +
            "values(#{id},#{areaCode},#{areaName},#{deptCode},#{deptName},#{riskCount},#{riskLevel},#{riskField},#{staData},#{FXYJXT})")
    Integer pushData(StaRewiDTO staRewi);

}
