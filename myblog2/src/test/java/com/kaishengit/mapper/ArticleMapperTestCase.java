package com.kaishengit.mapper;

import com.kaishengit.entity.Article;
import com.kaishengit.entity.ArticleWithBLOBs;
import com.kaishengit.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhao
 */
public class ArticleMapperTestCase {

    private SqlSession sqlSession;
    private ArticleMapper articleMapper;

    @Before
    public void init() {
        sqlSession = MybatisUtils.getSqlSession();
        articleMapper = sqlSession.getMapper(ArticleMapper.class);
    }

    @After
    public void close() {
        sqlSession.close();
    }

    @Test
    public void findByIdTest() {
        /*Article article = articleMapper.selectByPrimaryKey(20);
        System.out.println(article);*/
        ArticleWithBLOBs articleWithBLOBs = articleMapper.selectByPrimaryKey(20);
        System.out.println(articleWithBLOBs.getSimpleContent());

    }

}
