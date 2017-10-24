package com.kaishengit.mapper;

import com.kaishengit.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhao on 2017/10/24.
 */
public interface BookMapper {
    Book findBookById(Integer id);
    List<Book> findPage(@Param("offset")int offset, @Param("size") int size);
}
