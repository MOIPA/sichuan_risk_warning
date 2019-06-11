package com.sichuan.sichuanproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sichuan.sichuanproject.dto.WarningModelDTO;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author
 */

@Data
public class WarningModelVO {
    private Long warningModelId;

    private String name;

    private Integer type;

    private String orgName;

    private String creatorId;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp createTime;

    private Integer status;


    public WarningModelVO warningModelVOByDTO(WarningModelDTO warningModelDTO) {
        WarningModelVO warningModelVO = new WarningModelVO();
        warningModelVO.setWarningModelId(warningModelDTO.getId());
        warningModelVO.setName(warningModelDTO.getName());
        warningModelVO.setType(warningModelDTO.getType());
        warningModelVO.setOrgName(warningModelDTO.getOrgName());
        warningModelVO.setCreatorId(warningModelDTO.getCreatorId());
        warningModelVO.setCreateTime(warningModelDTO.getCreateTime());
        warningModelVO.setStatus(warningModelDTO.getStatus());

        return warningModelVO;
    }
}
