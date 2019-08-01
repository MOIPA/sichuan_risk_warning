package com.sichuan.sichuanproject.mapper.primary;

import com.sichuan.sichuanproject.domain.WarningSignal;
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
public interface WarningSignalMapper {

    /**
     * 新增预警信号
     *
     * @param warningSignal
     * @return
     */
    @Insert("insert into JG_FXYJ_WARNING_SIGNAL(Fxyj_Id,Fxyj_Domain_Id,Fxyj_Area_Number,Fxyj_Title,Fxyj_Desc,Fxyj_Level,Fxyj_Time,Fxyj_Model_Id,Fxyj_Detail_Url) values(#{fxyjId},#{fxyjDomainId},#{fxyjAreaNumber},#{fxyjTitle},#{fxyjDesc},#{fxyjLevel},#{fxyjTime},#{fxyjModelId},#{fxyjDetailUrl})")
    int addWarningSignal(WarningSignal warningSignal);

    /**
     * 查询预警信号
     *
     * @return
     */
    @Select("select * from JG_FXYJ_WARNING_SIGNAL s,warning_model wm where s.Fxyj_Model_Id=wm.id order by Fxyj_Time desc")
    List<WarningSignalVO> getWarningSignal();

}
