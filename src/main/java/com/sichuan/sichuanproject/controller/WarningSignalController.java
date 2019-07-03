package com.sichuan.sichuanproject.controller;

import com.github.pagehelper.PageInfo;
import com.sichuan.sichuanproject.domain.WarningSignal;
import com.sichuan.sichuanproject.service.WarningSignalService;
import com.sichuan.sichuanproject.vo.WarningSignalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author
 */

@CrossOrigin
@RestController
public class WarningSignalController {

    @Autowired
    private WarningSignalService warningSignalService;

    @RequestMapping(value = "/risk-warning/signal/add", method = RequestMethod.POST)
    public Integer addWarningSignal(@RequestBody @Valid WarningSignal warningSignal) {
        return warningSignalService.addWarningSignal(warningSignal);
    }

    @RequestMapping(value = "/risk-warning/signal/get", method = RequestMethod.GET)
    public PageInfo<WarningSignalVO> getWarningSignal(@RequestParam(value = "pageNum") Integer pageNum, @RequestParam(value = "pageSize") Integer pageSize) {
        return warningSignalService.getWarningSignal(pageNum, pageSize);
    }
}
