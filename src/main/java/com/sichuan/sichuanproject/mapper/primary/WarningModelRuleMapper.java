package com.sichuan.sichuanproject.mapper.primary;

import com.sichuan.sichuanproject.domain.WarningModelRule;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author
 */

@Mapper
@Repository
public interface WarningModelRuleMapper {

    /**
     * 配置预警模型规则
     *
     * @param warningModelRule
     * @return
     */
    @Insert("insert into warning_model_rule(warning_model_id, domain_id, key_word, start_time, high_risk_value, middle_high_risk_value, middle_risk_value, low_risk_value, high_risk_value_increment, middle_high_risk_value_increment, middle_risk_value_increment, low_risk_value_increment) values(#{warningModelId},#{domainId},#{keyWord},#{startTime},#{highRiskValue},#{middleHighRiskValue},#{middleRiskValue},#{lowRiskValue},#{highRiskValueIncrement},#{middleHighRiskValueIncrement},#{middleRiskValueIncrement},#{lowRiskValueIncrement})")
    int insertWarningModelRule(WarningModelRule warningModelRule);

    /**
     * 修改预警模型规则
     * 只能修改各级风险的风险值
     *
     * @param warningModelId
     * @param highRisk
     * @param middleHighRisk
     * @param middleRisk
     * @param lowRisk
     * @return
     */
    @Update("update warning_model_rule set high_risk_value=#{highRiskValue},middle_high_risk_value=#{middleHighRiskValue},middle_risk_value=#{middleRiskValue},low_risk_value=#{lowRiskValue} where warning_model_id=#{warningModelId}")
    int updateWarningModelRule(@Param("warningModelId") Long warningModelId, @Param("highRisk") Double highRisk, @Param("middleHighRisk") Double middleHighRisk, @Param("middleRisk") Double middleRisk, @Param("lowRisk") Double lowRisk);
}
