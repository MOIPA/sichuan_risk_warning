package com.sichuan.sichuanproject.mapper.primary;

import com.sichuan.sichuanproject.domain.RiskFeatureBasicInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 */

@Mapper
@Repository
public interface RiskFeatureBasicInfoMapper {

    /**
     * 批量插入风险特性基础信息
     *
     * @param riskFeatureBasicInfoList
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("<script>" +
            "insert into JG_ZSK_RISK(Risk_Feature_Name,Business_Classification,Characteristic_Index,Connection_Relation) values " +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.riskFeatureName},#{item.businessClassification},#{item.characteristicIndex},#{item.connectionRelation})" +
            "</foreach>" +
            "</script>")
    int addRiskFeatureBasicInfo(@Param("list") List<RiskFeatureBasicInfo> riskFeatureBasicInfoList);
}
