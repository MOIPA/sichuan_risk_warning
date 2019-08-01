package com.sichuan.sichuanproject.mapper.primary;

import com.sichuan.sichuanproject.domain.Organization;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 */

@Mapper
@Repository
public interface OrganizationMapper {

    /**
     * 新增部门
     *
     * @param organization
     * @return
     */
    @Insert("insert into organization_info(org_id,org_code,org_name,area_code,short_name,parent_org,is_delete,update_time,is_parent) values(#{orgId},#{orgCode},#{orgName},#{areaCode},#{shortName},#{parentOrg},#{isDelete},#{updateTime},#{isParent})")
    Integer insertOrganizationInfo(Organization organization);

    /**
     * 批量插入部门信息
     *
     * @param organizationList
     */
    @Insert("<script>" +
            "insert into organization_info(org_id,org_code,org_name,area_code,short_name,parent_org,is_delete,update_time,is_parent) values " +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.orgId},#{item.orgCode},#{item.orgName},#{item.areaCode},#{item.shortName},#{item.parentOrg},#{item.isDelete},#{item.updateTime},#{item.isParent})" +
            "</foreach>" +
            "</script>")
    void insertOrganizationInfoBatch(@Param("list") List<Organization> organizationList);

    /**
     * 修改部门信息
     *
     * @param organization
     * @return
     */
    @Update("update organization_info set org_code=#{orgCode},org_name=#{orgName},area_code=#{areaCode},short_name=#{shortName},parent_org=#{parentOrg},is_delete=#{isDelete},update_time=#{updateTime},is_parent=#{isParent} where org_id=#{orgId}")
    Integer updateOrganizationInfo(@Param("organization") Organization organization);

    /**
     * 根据部门id查找部门信息
     *
     * @param orgId
     * @return
     */
    @Select("select * from organization_info where org_id=#{orgId}")
    Organization getOrganizationInfoById(Long orgId);

    /**
     * 获取部门信息
     *
     * @return
     */
    @Select("select * from organization_info")
    List<Organization> getOrganizationInfo();

    /**
     * 根据名称获取部门信息
     *
     * @param name
     * @return
     */
    @Select("select * from organization_info where org_name like concat('%',#{name},'%')")
    List<Organization> getOrganizationInfoByName(@Param("name") String name);

    /**
     * 批量删除部门
     *
     * @param orgIds
     * @return
     */
    @Delete("<script>" +
            "delete from organization_info where org_id in " +
            "<foreach collection='list' item='id' separator=',' open='(' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    Integer deleteOrganizationsByIds(@Param("list") List<Long> orgIds);
}
