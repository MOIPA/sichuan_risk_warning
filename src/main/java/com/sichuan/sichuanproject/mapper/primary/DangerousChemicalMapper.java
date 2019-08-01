package com.sichuan.sichuanproject.mapper.primary;

import com.sichuan.sichuanproject.domain.DangerousChemical;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 */

@Mapper
@Repository
public interface DangerousChemicalMapper {

    /**
     * 批量添加危险化学品信息
     *
     * @param dangerousChemicalList
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("<script>" +
            "insert into JG_ZSK_GHS_DANGEROUS_LIST(Chemicals_Classification, Classification_ID, Chemicals_Number, Chemicals_Property, Chinese_Name, Chinese_Alias, English_Name, English_Alias, CAS_No, UN_No, Formula, Molecular_Weight, Structure, Manufacturer_Name, Manufacturer_URL, Business_Profile, Emergency_Telephone, Component_Information, Risk_Category, Pictogram_Encoding, Hazard_Statement, Warning_Words, Precautionary_Statemen, Dangerous_Goods_Classification, State, Appearance_Character, Solubility, Smell, Melting_Point, Boiling_Point, Zeolite, Vaporic_Pressure, pH, n_octanol, Density, Kinematic_Viscosity, Solubility_Water, Registration_Number, Maximum_Reserves, Dramatic_drugs, Chinese_SDS_Document) values " +
            "<foreach list='list' item='item' separator=','>" +
            "(#{item.chemicalsClassification},#{item.classificationID},#{item.chemicalsNumber},#{item.chemicalsProperty},#{item.chineseName},#{item.chineseAlias},#{item.englishName},#{item.englishAlias},#{item.casNo},#{item.unNo},#{item.formula},#{item.molecularWeight},#{item.structure},#{item.manufacturerName},#{item.manufacturerURL},#{item.businessProfile},#{item.emergencyTelephone},#{item.componentInformation},#{item.riskCategory},#{item.pictogramEncoding},#{item.hazardStatement},#{item.warningWords},#{item.precautionaryStatement},#{item.dangerousGoodsClassification},#{item.state},#{item.appearanceCharacter},#{item.solubility},#{item.smell},#{item.meltingPoint},#{item.boilingPoint},#{item.zeolite},#{item.vaporicPressure},#{item.ph},#{item.nOctanol},#{item.density},#{item.kinematicViscosity},#{item.solubilityWater},#{item.registrationNumber},#{item.maximumReserves},#{item.dramaticDrugs},#{item.chineseSdsDocument})" +
            "</foreach>" +
            "</script>")
    int addDangerousChemicalBatch(@Param("list") List<DangerousChemical> dangerousChemicalList);
}
