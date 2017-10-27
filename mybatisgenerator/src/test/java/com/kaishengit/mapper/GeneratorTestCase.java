package com.kaishengit.mapper;

import com.kaishengit.com.kaishengit.util.MyBatisUtil;
import com.kaishengit.entity.Book;
import com.kaishengit.entity.BookExample;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @Author zhao
 */
public class GeneratorTestCase {

    private SqlSession sqlSession;
    private BookMapper bookMapper;

    @Before
    public void init() {
        sqlSession = MyBatisUtil.getSqlSession();
        bookMapper = sqlSession.getMapper(BookMapper.class);
    }

    @After
    public void close() {
        sqlSession.close();
    }

    @Test
    public void selectAllTest() {
        List<Book> bookList = bookMapper.selectByExample(new BookExample());
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void selectByParamTest() {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andAuthorIdEqualTo(8)
                   .andTypeIdEqualTo(12);

        List<Book> bookList = bookMapper.selectByExample(bookExample);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void SelectByPriceAndName() {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andPriceBetween(40.0, 60.0)
                .andBookNameLike("%java%");

        List<Book> bookList = bookMapper.selectByExample(bookExample);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void updateByIdTest() {
        Book book = new Book();
        book.setId(23);
        book.setBookName("Head Fist Java 第二版");

        bookMapper.updateByPrimaryKeySelective(book);
        sqlSession.commit();
    }

    @Test
    public void orTest() {
        BookExample bookExample = new BookExample();
        bookExample.or().andAuthorIdEqualTo(1);
        bookExample.or().andTypeIdEqualTo(7);

        List<Book> bookList = bookMapper.selectByExample(bookExample);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

}
