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
     * 查询推送库的预警信号
     *
     * @return
     */
    @Select("select * from STA_REWI_DATA order by FXYJXT desc")
    List<StaRewiDTO> getWarningSignal();

}
