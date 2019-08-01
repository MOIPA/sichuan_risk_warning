package com.sichuan.sichuanproject.mapper.primary;

import com.sichuan.sichuanproject.domain.RiskResult;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author
 */

@Mapper
@Repository
public interface RiskResultMapper {

    /**
     * 插入结果
     *
     * @param riskResult
     * @return
     */
    @Insert("insert into risk_result(id, created_at, risk_value, warning_model_id) values(#{id},#{createdAt},#{riskValue},#{warningModelId})")
    int insertRiskResult(RiskResult riskResult);
}
