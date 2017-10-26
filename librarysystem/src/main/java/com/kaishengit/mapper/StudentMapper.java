package com.kaishengit.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhao on 2017/10/26.
 */
public interface StudentMapper {

    @Insert("insert into t_stu1 (name) values (#{name})")
    void save(@Param("name") String name);

    void batchSave(@Param("nameList")List<String> nameList);

    @Delete("delete from t_stu1 where id > #{id}")
    void batchDelete(Integer id);
}
