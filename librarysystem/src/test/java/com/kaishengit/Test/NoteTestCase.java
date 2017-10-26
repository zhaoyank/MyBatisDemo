package com.kaishengit.Test;

import com.kaishengit.entity.Student;
import com.kaishengit.mapper.BookMapper;
import com.kaishengit.mapper.StudentMapper;
import com.kaishengit.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhao on 2017/10/26.
 */
public class NoteTestCase {

    private SqlSession sqlSession;
    private StudentMapper studentMapper;

    @Before
    public void init() {
        sqlSession = MybatisUtil.getSqlSession();
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @After
    public void close() {
        sqlSession.close();
    }

    @Test
    public void batchDeleteTest() {
        studentMapper.batchDelete(1);
        sqlSession.commit();
    }

    @Test
    public void saveTest() {
        studentMapper.save("tom");
        sqlSession.commit();
    }

}
