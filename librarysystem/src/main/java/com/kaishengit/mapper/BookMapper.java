package com.kaishengit.mapper;

import com.kaishengit.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by zhao on 2017/10/24.
 */
public interface BookMapper {

    @Select("select * from t_book where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "price", column = "price"),
            @Result(property = "authorId", column = "author_id"),
            @Result(property = "typeId", column = "type_id"),
            @Result(property = "author", column = "author_id", one = @One(select = "com.kaishengit.mapper.AuthorMapper.findById")),
            @Result(property = "type", column = "type_id",one = @One(select = "com.kaishengit.mapper.TypeMapper.findById"))
    })
    Book findBookById(Integer id);

    /**
     * @param offset
     * @param size
     * @return 书籍集合
     */
    @Select("select * from t_book limit #{offset},#{size}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "price", column = "price"),
            @Result(property = "authorId", column = "author_id"),
            @Result(property = "typeId", column = "type_id"),
            @Result(property = "author", column = "author_id", one = @One(select = "com.kaishengit.mapper.AuthorMapper.findById")),
            @Result(property = "type", column = "type_id",one = @One(select = "com.kaishengit.mapper.TypeMapper.findById"))
    })
    List<Book> findPage(@Param("offset")int offset, @Param("size") int size);
    List<Book> findByTypeId(Integer typeId);

    List<Book> findByParam(Map<String, Object> serachMap);
    List<Book> findByIds(List<Integer> idList);

    @Insert("insert into t_book (book_name,price,author_id,type_id) values (#{bookName},#{price},#{authorId},#{typeId})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int save(Book book);

    @Delete("delete from t_book where id = #{id}")
    void deleteById(Integer id);
}
