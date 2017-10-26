package com.kaishengit.mapper;

import com.kaishengit.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhao on 2017/10/24.
 */
public interface BookMapper {
    Book findBookById(Integer id);
    List<Book> findPage(@Param("offset")int offset, @Param("size") int size);
    List<Book> findByTypeId(Integer typeId);

    List<Book> findByParam(Map<String, Object> serachMap);
    List<Book> findByIds(List<Integer> idList);
}
