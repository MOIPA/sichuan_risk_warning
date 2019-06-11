package com.sichuan.sichuanproject.service.impl;

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
 * @author
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
    public List<WarningModelVO> getWarningModel() {
        return warningModelMapper.getWarningModels()
                .stream().map((e) -> (WarningModelVO) OrikaMapper.map(e, WarningModelVO.class)).collect(Collectors.toList());
    }

    @Override
    public List<WarningModelVO> getWarningModelByName(String name) {
        List<WarningModelDTO> warningModelDTOList = warningModelMapper.getWarningModelByName(name);
        List<WarningModelVO> warningModelVOList = new ArrayList<>();

        warningModelDTOList.forEach((e) ->{
            WarningModelVO warningModelVO = new WarningModelVO();
            warningModelVO = warningModelVO.warningModelVOByDTO(e);
            warningModelVOList.add(warningModelVO);
        });

        return warningModelVOList;
    }

    @Override
    public Integer modifyWarningModel(ModifyWarningModelForm modifyWarningModelForm) {
        Integer result = warningModelMapper.updateWarningModel(modifyWarningModelForm.getWarningModelId(), modifyWarningModelForm.getName(), modifyWarningModelForm.getType(), modifyWarningModelForm.getOrgCode());

        return result;
    }

    @Override
    public List<WarningModelVO> getUnderReviewWarningModel() {
        List<WarningModelDTO> warningModelDTOList = warningModelMapper.getUnderReviewWarningModel();
        List<WarningModelVO> warningModelVOList = new ArrayList<>();
        warningModelDTOList.forEach((e) ->{
            WarningModelVO warningModelVO = new WarningModelVO();
            warningModelVO = warningModelVO.warningModelVOByDTO(e);
            warningModelVOList.add(warningModelVO);
        });

        return warningModelVOList;
    }

    @Override
    public List<WarningModelVO> getUnderReviewWarningModelByName(String name) {
        List<WarningModelVO> warningModelVOList = new ArrayList<>();
        List<WarningModelDTO> warningModelDTOList = warningModelMapper.getUnderReviewWarningModelByName(name);
        warningModelDTOList.forEach((e) ->{
            WarningModelVO warningModelVO = new WarningModelVO();
            warningModelVO = warningModelVO.warningModelVOByDTO(e);
            warningModelVOList.add(warningModelVO);
        });

        return warningModelVOList;
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
