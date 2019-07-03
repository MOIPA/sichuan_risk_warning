package com.sichuan.sichuanproject.mapper;

import com.sichuan.sichuanproject.domain.Opinion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author
 */

@Mapper
@Repository
public interface OpinionMapper {

    /**
     * 插入舆情信息
     *
     * @param opinion
     */
    @Insert("insert into JG_YQDSF_EVENT_BANK(Event_Id, Event_Type, Type_Keywords, Event_Title, Event_Date, Event_Abstract, Event_Level, Event_Status, Event_Emottonal, District_Code, URL, Source, Domain) values(#{eventId},#{eventType},#{typeKeyWords},#{eventTitle},#{eventDate},#{eventAbstract},#{eventLevel},#{eventStatus},#{eventEmottonal},#{districtCode},#{url},#{source},#{domain})")
    void insertOpinion(Opinion opinion);
}
