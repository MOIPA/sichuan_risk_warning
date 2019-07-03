package com.sichuan.sichuanproject.service;

import com.github.pagehelper.PageInfo;
import com.sichuan.sichuanproject.domain.WarningSignal;
import com.sichuan.sichuanproject.vo.WarningSignalVO;
import org.springframework.stereotype.Service;


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
}
