package com.kaishengit.mapper;

import com.kaishengit.entity.Type;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zhao on 2017/10/26.
 */
public interface TypeMapper {

    @Select("select * from t_type where id = #{id}")
    Type findById(Integer id);

}
