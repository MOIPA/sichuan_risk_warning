package com.sichuan.sichuanproject.service;

import com.github.pagehelper.PageInfo;
import com.sichuan.sichuanproject.domain.WarningSignal;
import com.sichuan.sichuanproject.dto.StaRewiDTO;
import com.sichuan.sichuanproject.dto.WarningModelDTO;
import com.sichuan.sichuanproject.vo.WarningModelVO;
import com.sichuan.sichuanproject.vo.WarningSignalVO;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author
 */

@Service
public interface WarningSignalService {

    /**
     * 新增预警信号
     *
     * @param warningSignal
     * @return
     */
    Integer addWarningSignal(WarningSignal warningSignal);

    /**
     * 查询预警信号
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<WarningSignalVO> getWarningSignal(Integer pageNum, Integer pageSize);

    /**
     * 查询推送数据库数据，可以用于以后差量对比更新
     */
    List<StaRewiDTO> getStaRewi();
}
