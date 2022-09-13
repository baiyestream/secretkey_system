package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Activate_information;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Activate_informationMapper extends BaseMapper<Activate_information> {


    @Insert("<script>" +
            "INSERT INTO activate_information(id,activationcode)VALUES" +
            "<foreach collection='activate_informations' item='activate_information' separator=',' > " +
            "(#{activate_information.id},#{activate_information.activationcode}) " +
            "</foreach>" +
            "</script>")
    boolean insertBatch(@Param("activate_informations") List<Activate_information> activate_informations);

}
