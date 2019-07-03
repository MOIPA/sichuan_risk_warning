package com.sichuan.sichuanproject.service;

import com.sichuan.sichuanproject.domain.RiskResult;
import org.springframework.stereotype.Service;

/**
 * @author
 */

@Service
public interface RiskResultService {

    /**
     * 插入结果
     *
     * @param riskResult
     */
    Integer addRiskResult(RiskResult riskResult);
}
