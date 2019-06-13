package com.sichuan.sichuanproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sichuan.sichuanproject.config.WarningModelStatus;
import com.sichuan.sichuanproject.domain.WarningModel;
import com.sichuan.sichuanproject.dto.WarningModelDTO;
import com.sichuan.sichuanproject.form.ApprovalWarningModelForm;
import com.sichuan.sichuanproject.form.ModifyWarningModelForm;
import com.sichuan.sichuanproject.form.WarningModelForm;
import com.sichuan.sichuanproject.mapper.WarningModelMapper;
import com.sichuan.sichuanproject.service.WarningModelService;
import com.sichuan.sichuanproject.utils.OrikaMapper;
import com.sichuan.sichuanproject.vo.WarningModelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Override
    public Integer addWarningModel(WarningModelForm warningModelForm) {
        WarningModel warningModel = (WarningModel) OrikaMapper.map(warningModelForm, WarningModel.class);

        warningModel.setId(null);
        warningModel.setCreateTime(new Timestamp(System.currentTimeMillis()));
        warningModel.setStatus(WarningModelStatus.UNDER_REVIEW.value());

        return warningModelMapper.addWarningModel(warningModel);
    }

    @Override
    public PageInfo<WarningModelVO> getWarningModel(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<WarningModelDTO> warningModelDTOList = warningModelMapper.getWarningModels();
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
    public Integer approvalWarningModel(ApprovalWarningModelForm approvalWarningModelForm) {
        Integer result = warningModelMapper.approvalWarningModel(approvalWarningModelForm.getWarningModelId(), approvalWarningModelForm.getStatus());
        return result;
    }

    @Override
    public Integer startWarningModel(Long warningModelId) {
        Integer result = warningModelMapper.startWarningModel(warningModelId);
        return result;
    }

    @Override
    public Integer closeWarningModel(Long warningModelId) {
        Integer result = warningModelMapper.closeWarningModel(warningModelId);
        return result;
    }

}
