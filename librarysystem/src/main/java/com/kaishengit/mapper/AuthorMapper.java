package com.kaishengit.mapper;

import com.kaishengit.entity.Author;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zhao on 2017/10/26.
 */
public interface AuthorMapper {

    @Select("select * from t_author where id = #{id}")
    Author findById(Integer id);
}
