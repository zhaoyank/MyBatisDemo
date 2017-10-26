package com.kaishengit.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhao on 2017/10/26.
 */
public interface StudentMapper {

    void save(@Param("name") String name);
    void batchSave(@Param("nameList")List<String> nameList);

}
