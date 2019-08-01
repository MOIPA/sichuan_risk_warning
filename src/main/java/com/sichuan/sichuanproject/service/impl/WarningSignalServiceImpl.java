package com.sichuan.sichuanproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sichuan.sichuanproject.config.DsEnum;
import com.sichuan.sichuanproject.domain.WarningSignal;
import com.sichuan.sichuanproject.dto.StaRewiDTO;
import com.sichuan.sichuanproject.mapper.primary.WarningSignalMapper;
import com.sichuan.sichuanproject.mapper.second.StaRewiMapper;
import com.sichuan.sichuanproject.service.DS;
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

    @Autowired
    private StaRewiMapper staRewiMapper;

    @DS(value = DsEnum.FIRST_DS)
    @Override
    public Integer addWarningSignal(WarningSignal warningSignal) {
        Integer result = warningSignalMapper.addWarningSignal(warningSignal);
        return result;
    }

    @DS(value = DsEnum.FIRST_DS)
    @Override
    public PageInfo<WarningSignalVO> getWarningSignal(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WarningSignalVO> warningSignalVOList = warningSignalMapper.getWarningSignal();
        PageInfo pageInfo = new PageInfo(warningSignalVOList);

        return pageInfo;
    }

    @DS(value = DsEnum.SECOND_DS)
    @Override
    public List<StaRewiDTO> getStaRewi() {
        return staRewiMapper.getWarningSignal();
    }
}
