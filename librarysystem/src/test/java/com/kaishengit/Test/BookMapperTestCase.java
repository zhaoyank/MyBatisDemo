package com.kaishengit.Test;

import com.kaishengit.entity.Book;
import com.kaishengit.mapper.BookMapper;
import com.kaishengit.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by zhao on 2017/10/24.
 */
public class BookMapperTestCase {

    private SqlSession sqlSession;
    private BookMapper bookMapper;

    @Before
    public void init() {
        sqlSession = MybatisUtil.getSqlSession();
        bookMapper = sqlSession.getMapper(BookMapper.class);
    }

    @After
    public void close() {
        sqlSession.close();
    }

    @Test
    public void findBookByIdTest() {
        Book book = bookMapper.findBookById(5);
        System.out.println(book);
    }

    @Test
    public void findPageTest() {
        List<Book> bookList = bookMapper.findPage(0, 3);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

}
