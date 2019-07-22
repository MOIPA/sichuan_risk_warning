package com.sichuan.sichuanproject.mapper;

import com.sichuan.sichuanproject.domain.WarningModel;
import com.sichuan.sichuanproject.dto.WarningModelDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 */

@Mapper
@Repository
public interface WarningModelMapper {

    /**
     * 新增预警模型
     *
     * @param warningModel
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into warning_model(name,type,org_code,creator_id,create_time,status) values(#{name},#{type},#{orgCode},#{creatorId},#{createTime},#{status})")
    int addWarningModel(WarningModel warningModel);

    /**
     * 查询预警模型列表
     *
     * @return
     */
    @Select("select wm.id,wm.name,wm.type,org.org_name,wm.creator_id,wm.create_time,wm.status from warning_model wm,organization_info org where wm.org_code = org.org_code order by create_time desc")
    List<WarningModelDTO> getWarningModels();

    /**
     * 根据状态查找预警模型列表
     *
     * @param status
     * @return
     */
    @Select("select wm.id,wm.name,wm.type,org.org_name,wm.creator_id,wm.create_time,wm.status from warning_model wm,organization_info org where wm.status=#{status} and wm.org_code = org.org_code order by create_time desc")
    List<WarningModelDTO> getWarningMdoelsByStatus(@Param("status") Integer status);

    /**
     * 根据预警模型名称搜索
     *
     * @param name
     * @return
     */
    @Select("select wm.id,wm.name,wm.type,org.org_name,wm.creator_id,wm.create_time,wm.status from warning_model wm,organization_info org where wm.org_code = org.org_code and wm.name like concat('%',#{name},'%') order by create_time desc")
    List<WarningModelDTO> getWarningModelByName(@Param("name") String name);

    /**
     * 修改预警模型信息
     *
     * @param warningModelId
     * @param name
     * @param type
     * @param orgCode
     * @return
     */
    @Update("update warning_model set name =#{name},type =#{type},org_code =#{orgCode} where id =#{warningModelId}")
    int updateWarningModel(@Param("warningModelId") Long warningModelId, @Param("name") String name, @Param("type") Integer type, @Param("orgCode") String orgCode);

    /**
     * 查找待审批的预警模型
     *
     * @return
     */
    @Select("select wm.id,wm.name,wm.type,org.org_name,wm.creator_id,wm.create_time,wm.status from warning_model wm,organization_info org where wm.org_code = org.org_code and wm.status =1 order by create_time desc")
    List<WarningModelDTO> getUnderReviewWarningModel();

    /**
     * 按照名称查找待审批的预警模型
     *
     * @param name
     * @return
     */
    @Select("select wm.id,wm.name,wm.type,org.org_name,wm.creator_id,wm.create_time,wm.status from warning_model wm,organization_info org where wm.org_code = org.org_code and wm.status =1 and wm.name like concat('%',#{name},'%') order by create_time desc")
    List<WarningModelDTO> getUnderReviewWarningModelByName(@Param("name") String name);

    /**
     * 查找审批通过的预警模型
     *
     * @return
     */
    @Select("select wm.id,wm.name,wm.type,org.org_name,wm.creator_id,wm.create_time,wm.status from warning_model wm,organization_info org where wm.org_code = org.org_code and (wm.status =3 or wm.status =4 or wm.status=5) order by create_time desc")
    List<WarningModelDTO> getReviewedWarningModel();

    /**
     * 按照状态查找审批通过的预警模型
     *
     * @param status
     * @return
     */
    @Select("select wm.id,wm.name,wm.type,org.org_name,wm.creator_id,wm.create_time,wm.status from warning_model wm,organization_info org where wm.org_code = org.org_code and wm.status =#{status} order by create_time desc")
    List<WarningModelDTO> getReviewedWarningModelByStatus(@Param("status") Integer status);

    /**
     * 按照名称查找审批通过的预警模型
     *
     * @param name
     * @return
     */
    @Select("select wm.id,wm.name,wm.type,org.org_name,wm.creator_id,wm.create_time,wm.status from warning_model wm,organization_info org where wm.org_code = org.org_code and (wm.status =3 or wm.status =4 or wm.status =5) and wm.name like concat('%',#{name},'%') order by create_time desc")
    List<WarningModelDTO> getReviewedWarningModelByName(@Param("name") String name);

    /**
     * 审批预警模型
     *
     * @param warningModelId
     * @param status
     * @return
     */
    @Update("update warning_model set status =#{status} where id =#{warningModelId} and status =1")
    Integer approvalWarningModel(@Param("warningModelId") Long warningModelId, @Param("status") Integer status);

    /**
     * 启动模型
     *
     * @param warningModelId
     * @return
     */
    @Update("update warning_model set status = 4 where id =#{warningModelId} and (status =3 or status =5)")
    Integer startWarningModel(@Param("warningModelId") Long warningModelId);

    /**
     * 关闭模型
     *
     * @param warningModelId
     * @return
     */
    @Update("update warning_model set status = 5 where id =#{warningModelId} and status =4")
    Integer closeWarningModel(@Param("warningModelId") Long warningModelId);

    /**
     * 删除模型
     *
     * @param warningModelId
     * @return
     */
    @Delete("delete from warning_model where id =#{warningModelId} and status=5")
    Integer deleteWarningModel(@Param("warningModelId") Long warningModelId);
}
