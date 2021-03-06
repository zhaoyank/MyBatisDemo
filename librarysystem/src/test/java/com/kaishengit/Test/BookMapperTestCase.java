package com.kaishengit.Test;

import com.kaishengit.entity.Book;
import com.kaishengit.mapper.BookMapper;
import com.kaishengit.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhao
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

        /*sqlSession.close();

        SqlSession sqlSession2 = MybatisUtil.getSqlSession();
        BookMapper bookMapper2 = sqlSession2.getMapper(BookMapper.class);

        Book book2 = bookMapper2.findBookById(5);
        sqlSession2.close();

        System.out.println(book);*/
    }

    @Test
    public void findPageTest() {
        List<Book> bookList = bookMapper.findPage(0, 3);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void findByTypeIdTest() {
        List<Book> bookList = bookMapper.findByTypeId(12);
        for(Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void findByParamTest() {
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put("bookName", "%java%");
        //searchMap.put("typeName", "%计算机%");
        searchMap.put("authorName", "周志明");

        List<Book> bookList = bookMapper.findByParam(searchMap);

        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void findByIdsTest() {
        List<Integer> idList = Arrays.asList(3,5,7);

        List<Book> bookList = bookMapper.findByIds(idList);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void saveTest() {
        Book book = new Book();
        book.setBookName("Head First Java 第三版");
        book.setPrice(68.24);
        book.setAuthorId(8);
        book.setTypeId(12);

        int id = bookMapper.save(book);
        System.out.println(book.getId());

        sqlSession.commit();
    }

    @Test
    public void deleteByIdTest() {
        bookMapper.deleteById(21);
        sqlSession.commit();
    }

}
