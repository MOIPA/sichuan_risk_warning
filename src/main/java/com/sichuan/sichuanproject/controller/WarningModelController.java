package com.sichuan.sichuanproject.controller;

import com.github.pagehelper.PageInfo;
import com.sichuan.sichuanproject.form.ApprovalWarningModelForm;
import com.sichuan.sichuanproject.form.ModifyWarningModelForm;
import com.sichuan.sichuanproject.form.WarningModelForm;
import com.sichuan.sichuanproject.service.WarningModelService;
import com.sichuan.sichuanproject.vo.WarningModelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author
 */

@CrossOrigin
@RestController
public class WarningModelController {
    @Autowired
    private WarningModelService warningModelService;

    @RequestMapping(value = "/risk-warning/warning-model/add", method = RequestMethod.POST)
    public Integer addWarningModel(@RequestBody @Valid WarningModelForm warningModelForm) {
        return warningModelService.addWarningModel(warningModelForm);
    }

    @RequestMapping(value = "/risk-warning/warning-model/get", method = RequestMethod.GET)
    public PageInfo<WarningModelVO> getWarningModels(@RequestParam(value = "pageNum") int pageNum, @RequestParam(value = "pageSize") int pageSize) {
        return warningModelService.getWarningModel(pageNum, pageSize);
    }

    @RequestMapping(value = "/risk-warning/warning-model/get/name", method = RequestMethod.GET)
    public List<WarningModelVO> getWarningModelByName(@RequestParam(value = "name") String name) {
        return warningModelService.getWarningModelByName(name);
    }

    @RequestMapping(value = "/risk-warning/warning-model/modify", method = RequestMethod.POST)
    public Integer modifyWarningModel(@RequestBody ModifyWarningModelForm modifyWarningModelForm) {
        return warningModelService.modifyWarningModel(modifyWarningModelForm);
    }

    @RequestMapping(value = "/risk-warning/warning-model/get/under-review", method = RequestMethod.GET)
    public List<WarningModelVO> getUnderReviewWarningModel() {
        return warningModelService.getUnderReviewWarningModel();
    }

    @RequestMapping(value = "/risk-warning/warning-model/get/under-review/name", method = RequestMethod.GET)
    public List<WarningModelVO> getUnderReviewWarningModelByName(@RequestParam(value = "name") String name) {
        return warningModelService.getUnderReviewWarningModelByName(name);
    }

    @RequestMapping(value = "/risk-warning/warning-model/approval", method = RequestMethod.POST)
    public Integer approvalWarningModel(@RequestBody ApprovalWarningModelForm approvalWarningModelForm) {
        return warningModelService.approvalWarningModel(approvalWarningModelForm);
    }

    @RequestMapping(value = "/risk-warning/warning-model/start/{warningModelId}", method = RequestMethod.POST)
    public Integer startWarningModel(@PathVariable(value = "warningModelId") Long warningModelId) {
        return warningModelService.startWarningModel(warningModelId);
    }

    @RequestMapping(value = "/risk-warning/warning-model/close/{warningModelId}", method = RequestMethod.POST)
    public Integer closeWarningModel(@PathVariable(value = "warningModelId") Long warningModelId) {
        return warningModelService.closeWarningModel(warningModelId);
    }

}
