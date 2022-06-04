package com.itxiaodu.credit.test;
import com.itxiaodu.credit.entity.Role;
import com.itxiaodu.credit.mapper.AdminMapper;
import com.itxiaodu.credit.entity.Admin;
import com.itxiaodu.credit.mapper.RoleMapper;
import com.itxiaodu.credit.service.inf.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class) //单元测试框架  使用注解
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-tx.xml"})//加载配置文件
public class MysqlTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void testRole(){

        for (int i = 0; i < 100; i++) {
            roleMapper.insert(new Role(null,"role"+i));
        }
    }

    @Test
    public void testMysql() throws SQLException {
        Connection connection=dataSource.getConnection();
        System.out.println(connection.toString());
    }
    @Test
    public void query(){
        int id=2;
        Admin admin = adminMapper.selectByPrimaryKey(id);
        System.out.println(admin.toString());
    }
    @Test
    public void testAdd(){
        Admin admin = new Admin(2,"admin1","123456789","yehao","yehao@qq.com","18810215462",new Date(),null,null);
        int count = adminMapper.insert(admin);
        System.out.println(" 添加成员： "+count);
    }
    @Test
    public void testSave(){
        Admin admin = new Admin(3,"admin2","123456789","chuanglong","chuanglong@qq.com","18810215463",new Date(),null,null);
        adminService.save(admin);
    }
    @Test
    public void testLog(){
        Logger logger = LoggerFactory.getLogger(MysqlTest.class);
        logger.debug(" debug !");
        logger.info(" info !");
        logger.warn(" warn !");
        logger.error(" error !");
    }
    @Test
    public void addData(){
        for (int i = 0; i < 100; i++) {
            adminMapper.insert(new Admin(i+2,"admin"+i,"admin"+i,"admin"+i,i+"@qq.com",null,new Date(),null,null));
        }
    }
}

