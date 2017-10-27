package com.kaishengit.mapper;

import com.kaishengit.entity.Admin;
import com.kaishengit.entity.AdminExample;
import com.kaishengit.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AdminMapperTestCase {

    private SqlSession sqlSession;
    private AdminMapper adminMapper;

    @Before
    public void init() {
        sqlSession = MybatisUtils.getSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);
    }

    @After
    public void close() {
        sqlSession.close();
    }

    @Test
    public void findByNameTest() {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAdminNameEqualTo("admin");

        List<Admin> adminList = adminMapper.selectByExample(adminExample);

        for (Admin admin : adminList) {
            System.out.println(admin);
        }
    }

    @Test
    public void findByIdTest() {
        Admin admin = adminMapper.selectByPrimaryKey(1);
        System.out.println(admin);
    }
}
