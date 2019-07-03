package com.sichuan.sichuanproject.service;

import com.sichuan.sichuanproject.form.DangerousChemicalForm;
import com.sichuan.sichuanproject.form.RiskFeatureBasicInfoForm;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 */

@Service
public interface RiskFeatureService {

    /**
     * 批量插入风险特征基础信息
     *
     * @param riskFeatureBasicInfoFormList
     * @return
     */
    String addRiskFeatureBasicInfoBatch(List<RiskFeatureBasicInfoForm> riskFeatureBasicInfoFormList);

    /**
     * 批量插入危险化学品信息
     *
     * @param dangerousChemicalFormList
     * @return
     */
    String addDangerousChemicalBatch(List<DangerousChemicalForm> dangerousChemicalFormList);
}
