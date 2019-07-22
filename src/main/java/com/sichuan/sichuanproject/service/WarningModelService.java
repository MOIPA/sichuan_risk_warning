package com.sichuan.sichuanproject.service;

import com.github.pagehelper.PageInfo;
import com.sichuan.sichuanproject.form.*;
import com.sichuan.sichuanproject.vo.WarningModelVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 */

@Service
public interface WarningModelService {

    /**
     * 新增风险预警模型
     *
     * @param warningModelForm
     * @return
     */
    Integer addWarningModel(WarningModelForm warningModelForm);

    /**
     * 查找风险预警模型
     *
     * @param pageNum
     * @param pageSize
     * @param status
     * @return
     */
    PageInfo<WarningModelVO> getWarningModel(Integer pageNum, Integer pageSize, Integer status);

    /**
     * 按名称搜索风险预警模型
     *
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<WarningModelVO> getWarningModelByName(String name, Integer pageNum, Integer pageSize);

    /**
     * 修改风险预警模型
     *
     * @param modifyWarningModelForm
     * @return
     */
    Integer modifyWarningModel(ModifyWarningModelForm modifyWarningModelForm);

    /**
     * 查找待审批的模型
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<WarningModelVO> getUnderReviewWarningModel(Integer pageNum, Integer pageSize);

    /**
     * 按名称查找待审批的模型
     *
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<WarningModelVO> getUnderReviewWarningModelByName(String name, Integer pageNum, Integer pageSize);

    /**
     * 查找审批通过的模型
     *
     * @param pageNum
     * @param pageSize
     * @param status
     * @return
     */
    PageInfo<WarningModelVO> getReviewedWarningModel(Integer pageNum, Integer pageSize, Integer status);

    /**
     * 按名称查找审批通过的模型
     *
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<WarningModelVO> getReviewedWarningModelByName(String name, Integer pageNum, Integer pageSize);

    /**
     * 审批预警模型
     *
     * @param approvalWarningModelForm
     * @return
     */
    Integer approvalWarningModel(ApprovalWarningModelForm approvalWarningModelForm);

    /**
     * 启动模型
     *
     * @param warningModelId
     * @return
     */
    Integer startWarningModel(Long warningModelId);

    /**
     * 关闭模型
     *
     * @param warningModelId
     * @return
     */
    Integer closeWarningModel(Long warningModelId);

    /**
     * 删除模型
     *
     * @param warningModelId
     * @return
     */
    Integer deleteWarningModel(Long warningModelId);

    /**
     * 设置模型规则
     *
     * @param warningModelRuleForm
     * @return
     */
    Integer setWarningModelRule(WarningModelRuleForm warningModelRuleForm);

    /**
     * 修改模型规则
     *
     * @param modifyWarningModelRuleForm
     * @return
     */
    Integer modifyWarningModelRule(ModifyWarningModelRuleForm modifyWarningModelRuleForm);
}
