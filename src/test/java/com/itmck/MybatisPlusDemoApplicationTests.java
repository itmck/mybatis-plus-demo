package com.itmck;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itmck.base.utils.PageParam;
import com.itmck.dao.UserMapper;
import com.itmck.pojo.User;
import com.itmck.service.RiskIcrQueryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RiskIcrQueryService riskIcrQueryService;
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }


    @Test
    public void testSelect2() {
        System.out.println(("----- selectByPage method test ------"));
        //使用分页之前,必须先制定分页插件,否则分页无法使用
        //1-----------制定分页插件
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");//设置使用mysql作为分页
        //2-----------设置分页参数
        Page<User> userPage = new Page<>();
        userPage.setCurrent(1);
        userPage.setSize(5);
        //3----------------查询
        IPage<User> userIPage = userMapper.selectPage(userPage, null);//SELECT id,name,email,age FROM user LIMIT ?,?
        List<User> records = userIPage.getRecords();
        for (User record : records) {

            System.out.println("======================="+record);
        }
    }


    @Test
    public void testInsert() {

        System.out.println(("----- insert method test ------"));
        User user = new User();
        user.setName("wxp123");
        user.setAge(24);
        user.setEmail("956411425@qq.com");
        int i=0;
        while (i<5){
            int insert = userMapper.insert(user);//INSERT INTO user ( id, name, email, age ) VALUES ( ?, ?, ?, ? )
            i++;
        }

    }


    @Test
    public void testUpdate() {

        System.out.println(("----- update method test ------"));
        User user = new User();
        user.setName("mck");
        user.setAge(24);
        user.setEmail("347451331@qq.com");
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id", 1173108471533436929L);
        /**
         * 参数1:新的值
         */
        int update = userMapper.update(user, userQueryWrapper);//UPDATE user SET name=?, email=?, age=? WHERE (id = ?)
        Assert.assertEquals(1, update);
        if (update == 1){

            System.out.println("update成功");
        }else{
            System.out.println("update失败");
        }
    }

    @Test
    public void testDelete(){

        System.out.println(("----- delete method test ------"));
//        int i = userMapper.deleteById(1173113442471559170L);//删除一个 DELETE FROM user WHERE id=?
//        Assert.assertEquals(1, i);

//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name", "wxp");
//        int i1 = userMapper.deleteByMap(map);//DELETE FROM user WHERE name = ?

        ArrayList<Long> longs = new ArrayList<>();
        longs.add(1173108471533436929L);
        longs.add(1173113442471559171L);
        int i = userMapper.deleteBatchIds(longs);//批量删除 DELETE FROM user WHERE id IN ( ? , ? )
        Assert.assertEquals(2, i);
    }


    @Test
    public void findAllByPage(){

        PageParam mySqlPage = new PageParam();
        mySqlPage.setCurrentPage(2);
        mySqlPage.setLimit(5);
        System.out.println("offset:"+mySqlPage.getOffset());
        List<User> list = userMapper.findAllByPage(mySqlPage);
        for (User user : list) {
            System.out.println("------------"+user);
        }

    }

    @Test
    public void run11(){

        try {
            String name = riskIcrQueryService.queryList();
            String s = riskIcrQueryService.respInformation();
            System.out.println(name+" "+s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void run12(){
        System.out.println(("----- selectByPage method test ------"));
        //使用分页之前,必须先制定分页插件,否则分页无法使用
        //1-----------制定分页插件
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");//设置使用mysql作为分页
        //2-----------设置分页参数
        Page<User> userPage = new Page<>();
        userPage.setCurrent(1);
        userPage.setSize(5);
        //3----------------查询
        IPage<User> userIPage = userMapper.selectPage(userPage, null);//SELECT id,name,email,age FROM user LIMIT ?,?
        List<User> records = userIPage.getRecords();
        for (User record : records) {

            System.out.println("======================="+record);
        }
    }
}
