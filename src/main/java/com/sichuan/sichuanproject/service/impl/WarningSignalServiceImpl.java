package com.sichuan.sichuanproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sichuan.sichuanproject.domain.WarningSignal;
import com.sichuan.sichuanproject.mapper.WarningSignalMapper;
import com.sichuan.sichuanproject.service.WarningSignalService;
import com.sichuan.sichuanproject.vo.WarningSignalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author
 */

@Component
public class WarningSignalServiceImpl implements WarningSignalService {

    @Autowired
    private WarningSignalMapper warningSignalMapper;

    @Override
    public Integer addWarningSignal(WarningSignal warningSignal) {
        Integer result = warningSignalMapper.addWarningSignal(warningSignal);
        return result;
    }

    @Override
    public PageInfo<WarningSignalVO> getWarningSignal(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WarningSignalVO> warningSignalVOList = warningSignalMapper.getWarningSignal();
        PageInfo pageInfo = new PageInfo(warningSignalVOList);

        return pageInfo;
    }
}
