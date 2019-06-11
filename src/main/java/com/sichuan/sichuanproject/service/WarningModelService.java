package com.sichuan.sichuanproject.service;

import com.sichuan.sichuanproject.form.ApprovalWarningModelForm;
import com.sichuan.sichuanproject.form.ModifyWarningModelForm;
import com.sichuan.sichuanproject.form.WarningModelForm;
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
     * @return
     */
    List<WarningModelVO> getWarningModel();

    /**
     * 按名称搜索风险预警模型
     *
     * @param name
     * @return
     */
    List<WarningModelVO> getWarningModelByName(String name);

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
     * @return
     */
    List<WarningModelVO> getUnderReviewWarningModel();

    /**
     * 按名称查找待审批的模型
     *
     * @param name
     * @return
     */
    List<WarningModelVO> getUnderReviewWarningModelByName(String name);

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

}
