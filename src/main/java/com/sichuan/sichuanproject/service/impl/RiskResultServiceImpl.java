package com.sichuan.sichuanproject.service.impl;

import com.sichuan.sichuanproject.domain.RiskResult;
import com.sichuan.sichuanproject.mapper.RiskResultMapper;
import com.sichuan.sichuanproject.service.RiskResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author
 */

@Component
public class RiskResultServiceImpl implements RiskResultService {

    @Autowired
    private RiskResultMapper riskResultMapper;

    @Override
    public Integer addRiskResult(RiskResult riskResult) {
        return riskResultMapper.insertRiskResult(riskResult);
    }
}
