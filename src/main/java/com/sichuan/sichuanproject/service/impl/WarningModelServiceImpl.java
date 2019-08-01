package com.sichuan.sichuanproject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sichuan.sichuanproject.config.BaseResult;
import com.sichuan.sichuanproject.config.WarningModelStatus;
import com.sichuan.sichuanproject.domain.WarningModel;
import com.sichuan.sichuanproject.domain.WarningModelRule;
import com.sichuan.sichuanproject.dto.ScheduleJobDTO;
import com.sichuan.sichuanproject.dto.WarningModelDTO;
import com.sichuan.sichuanproject.form.*;
import com.sichuan.sichuanproject.mapper.primary.WarningModelMapper;
import com.sichuan.sichuanproject.mapper.primary.WarningModelRuleMapper;
import com.sichuan.sichuanproject.service.WarningModelService;
import com.sichuan.sichuanproject.utils.OrikaMapper;
import com.sichuan.sichuanproject.vo.WarningModelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shengao
 */
@Component
public class WarningModelServiceImpl implements WarningModelService {

    @Autowired
    private WarningModelMapper warningModelMapper;

    @Autowired
    private WarningModelRuleMapper warningModelRuleMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Integer addWarningModel(WarningModelForm warningModelForm) {
        WarningModel warningModel = (WarningModel) OrikaMapper.map(warningModelForm, WarningModel.class);

        warningModel.setId(null);
        warningModel.setCreateTime(new Timestamp(System.currentTimeMillis()));
        warningModel.setStatus(WarningModelStatus.UNDER_REVIEW.value());

        return warningModelMapper.addWarningModel(warningModel);
    }

    @Override
    public PageInfo<WarningModelVO> getWarningModel(Integer pageNum, Integer pageSize, Integer status) {
        PageHelper.startPage(pageNum,pageSize);
        List<WarningModelDTO> warningModelDTOList = new ArrayList<>();
        if (status.equals(0)) {
            warningModelDTOList = warningModelMapper.getWarningModels();
        }else {
            warningModelDTOList = warningModelMapper.getWarningMdoelsByStatus(status);
        }
        PageInfo pageInfo = new PageInfo(warningModelDTOList);
        List<WarningModelVO> warningModelVOList = warningModelDTOList.stream().map((e) ->(WarningModelVO) OrikaMapper.map(e, WarningModelVO.class)).collect(Collectors.toList());
        pageInfo.setList(warningModelVOList);
        return pageInfo;
    }

    @Override
    public PageInfo<WarningModelVO> getWarningModelByName(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<WarningModelDTO> warningModelDTOList = warningModelMapper.getWarningModelByName(name);
        PageInfo pageInfo = new PageInfo(warningModelDTOList);
        List<WarningModelVO> warningModelVOList = warningModelDTOList.stream().map((e) ->(WarningModelVO) OrikaMapper.map(e, WarningModelVO.class)).collect(Collectors.toList());
        pageInfo.setList(warningModelVOList);
        return pageInfo;

    }

    @Override
    public Integer modifyWarningModel(ModifyWarningModelForm modifyWarningModelForm) {
        return warningModelMapper.updateWarningModel(modifyWarningModelForm.getWarningModelId(), modifyWarningModelForm.getName(), modifyWarningModelForm.getType(), modifyWarningModelForm.getOrgCode());
    }

    @Override
    public PageInfo<WarningModelVO> getUnderReviewWarningModel(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WarningModelDTO> warningModelDTOList = warningModelMapper.getUnderReviewWarningModel();
        PageInfo pageInfo = new PageInfo(warningModelDTOList);
        List<WarningModelVO> warningModelVOList = warningModelDTOList.stream().map((e) -> (WarningModelVO) OrikaMapper.map(e, WarningModelVO.class)).collect(Collectors.toList());
        pageInfo.setList(warningModelVOList);
        return pageInfo;
    }

    @Override
    public PageInfo<WarningModelVO> getUnderReviewWarningModelByName(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WarningModelDTO> warningModelDTOList = warningModelMapper.getUnderReviewWarningModelByName(name);
        PageInfo pageInfo = new PageInfo(warningModelDTOList);
        List<WarningModelVO> warningModelVOList = warningModelDTOList.stream().map((e) -> (WarningModelVO) OrikaMapper.map(e, WarningModelVO.class)).collect(Collectors.toList());
        pageInfo.setList(warningModelVOList);
        return pageInfo;
    }

    @Override
    public PageInfo<WarningModelVO> getReviewedWarningModel(Integer pageNum, Integer pageSize, Integer status) {
        PageHelper.startPage(pageNum, pageSize);
        List<WarningModelDTO> warningModelDTOList = new ArrayList<>();
        if (status.equals(0)) {
            warningModelDTOList = warningModelMapper.getReviewedWarningModel();
        }else {
            warningModelDTOList = warningModelMapper.getReviewedWarningModelByStatus(status);
        }

        PageInfo pageInfo = new PageInfo(warningModelDTOList);
        List<WarningModelVO> warningModelVOList = warningModelDTOList.stream().map((e) ->(WarningModelVO) OrikaMapper.map(e, WarningModelVO.class)).collect(Collectors.toList());
        pageInfo.setList(warningModelVOList);
        return pageInfo;
    }

    @Override
    public PageInfo<WarningModelVO> getReviewedWarningModelByName(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WarningModelDTO> warningModelDTOList = warningModelMapper.getReviewedWarningModelByName(name);
        PageInfo pageInfo = new PageInfo(warningModelDTOList);
        List<WarningModelVO> warningModelVOList = warningModelDTOList.stream().map((e) -> (WarningModelVO) OrikaMapper.map(e, WarningModelVO.class)).collect(Collectors.toList());
        pageInfo.setList(warningModelVOList);
        return pageInfo;
    }

    @Override
    public Integer approvalWarningModel(ApprovalWarningModelForm approvalWarningModelForm) {
        Integer result = warningModelMapper.approvalWarningModel(approvalWarningModelForm.getWarningModelId(), approvalWarningModelForm.getStatus());
        return result;
    }

    @Override
    public Integer startWarningModel(Long warningModelId) {
        Integer result = warningModelMapper.startWarningModel(warningModelId);

        Long id = warningModelId;
        String jobName = "risk-warning-model-" + warningModelId;
        String jobGroup = "risk-warning";
        String methodName = "run1";
        String beanClass = "com.sichuan.sichuanproject.schedule.TaskTest";
        Integer status = 0;
        String cronExpression = "0 0 0/1 * * ?";
        String params = "";
        String remark = "";
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        Timestamp modifyTime = new Timestamp(System.currentTimeMillis());
        ScheduleJobDTO scheduleJobDTO = new ScheduleJobDTO(id, jobName, jobGroup, methodName, beanClass, status, cronExpression, params, remark, createTime, modifyTime);
        restTemplate.postForObject("http://59.225.206.13:8761/risk-warning/schedule-job/add",scheduleJobDTO, BaseResult.class);

        return result;
    }

    @Override
    public Integer closeWarningModel(Long warningModelId) {
        Integer result = warningModelMapper.closeWarningModel(warningModelId);
        restTemplate.postForObject("http://59.225.206.13:8761/risk-warning/schedule-job/pause?jobId="+warningModelId,"",BaseResult.class);

        return result;
    }

    @Override
    public Integer deleteWarningModel(Long warningModelId) {
        Integer result = warningModelMapper.deleteWarningModel(warningModelId);
        restTemplate.postForObject("http://59.225.206.13:8761/risk-warning/schedule-job/remove?jobId="+warningModelId,"",BaseResult.class);

        return result;
    }

    @Override
    public Integer setWarningModelRule(WarningModelRuleForm warningModelRuleForm) {
        WarningModelRule warningModelRule = (WarningModelRule) OrikaMapper.map(warningModelRuleForm, WarningModelRule.class);
        Integer result = warningModelRuleMapper.insertWarningModelRule(warningModelRule);
        restTemplate.postForObject("http://59.225.206.13:8761/risk-warning/warning-model/rule/set",warningModelRule,Integer.class);
        return result;
    }

    @Override
    public Integer modifyWarningModelRule(ModifyWarningModelRuleForm modifyWarningModelRuleForm) {
        Integer result = warningModelRuleMapper.updateWarningModelRule(modifyWarningModelRuleForm.getWarningModelId(), modifyWarningModelRuleForm.getHighRisk(), modifyWarningModelRuleForm.getMiddleHighRisk(), modifyWarningModelRuleForm.getMiddleRisk(), modifyWarningModelRuleForm.getLowRisk());
        return result;
    }

}
