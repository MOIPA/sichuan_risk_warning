package com.sichuan.sichuanproject.service.impl;

import com.sichuan.sichuanproject.domain.DangerousChemical;
import com.sichuan.sichuanproject.domain.RiskFeatureBasicInfo;
import com.sichuan.sichuanproject.form.DangerousChemicalForm;
import com.sichuan.sichuanproject.form.RiskFeatureBasicInfoForm;
import com.sichuan.sichuanproject.mapper.DangerousChemicalMapper;
import com.sichuan.sichuanproject.mapper.RiskFeatureBasicInfoMapper;
import com.sichuan.sichuanproject.service.RiskFeatureService;
import com.sichuan.sichuanproject.utils.OrikaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author
 */

@Component
public class RiskFeatureServiceImpl implements RiskFeatureService {

    @Autowired
    private RiskFeatureBasicInfoMapper riskFeatureBasicInfoMapper;

    @Autowired
    private DangerousChemicalMapper dangerousChemicalMapper;

    @Override
    public String addRiskFeatureBasicInfoBatch(List<RiskFeatureBasicInfoForm> riskFeatureBasicInfoFormList) {
        String result = "fail";
        List<RiskFeatureBasicInfo> riskFeatureBasicInfoList = riskFeatureBasicInfoFormList.stream().map((e) ->(RiskFeatureBasicInfo) OrikaMapper.map(e, RiskFeatureBasicInfo.class)).collect(Collectors.toList());
        Integer num = riskFeatureBasicInfoMapper.addRiskFeatureBasicInfo(riskFeatureBasicInfoList);
        if (num.equals(riskFeatureBasicInfoFormList.size())) {
            result = "success";
        }

        return result;
    }

    @Override
    public String addDangerousChemicalBatch(List<DangerousChemicalForm> dangerousChemicalFormList) {
        String result = "fail";
        List<DangerousChemical> dangerousChemicalList = dangerousChemicalFormList.stream().map((e) ->(DangerousChemical) OrikaMapper.map(e, DangerousChemical.class)).collect(Collectors.toList());
        int num = dangerousChemicalMapper.addDangerousChemicalBatch(dangerousChemicalList);
        if (num == dangerousChemicalFormList.size()) {
            result = "success";
        }

        return result;
    }
}
