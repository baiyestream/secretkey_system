package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Activatecode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ActivatecodeMapper extends BaseMapper<Activatecode> {


    @Insert("<script>"+
            "INSERT INTO activatecode(id,activationcode)VALUES"  +
            "<foreach collection='activatecodes' item='activatecode' separator=',' > " +
            "(#{activatecode.id},#{activatecode.activationcode})" +
            "</foreach>" +
            "</script>")
    boolean insertBatch01(@Param("activatecodes") List<Activatecode> activatecodes);



}
