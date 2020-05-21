package com.itmck.web;

import com.itmck.pojo.User;
import com.itmck.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by it_mck 2019/9/14 21:06
 *
 * @Description:
 * @Version: 1.0
 */
@Slf4j
@RestController
@RequestMapping(value = "/crud")
public class CrudController {

    @Autowired
    private UserService userService;


    /**
     * 获取所有数据列表
     * @return
     */
    @RequestMapping("/list")
    public List<User> getList(){
        log.info("正在获取所有数据列表");

        List<User> lists = null;
        try {
            lists = userService.getLists();
        } catch (Exception e) {
            String message = e.getMessage();
            System.out.println(message);
        }
        return  lists;
    }


    /**
     * 根据主键进行查询
     * @param id
     * @return
     */
    @RequestMapping("/one/{id}")
    public User findById(@PathVariable Long id){

       return userService.selectById(id);
    }


    /**
     * 条件查询 使用 mybatis-plus的 objectMapper.selectByMap(Map map)方法
     * @param user
     * @return
     */
    @RequestMapping("/cond")
    public List<User> findByCondition(@RequestBody User user){

        List<User> list =  userService.findByCondition(user);

        return list;
    }

    /**
     * 条件查询 使用 mybatis-plus的 objectMapper.allEq(Map map, Boolean false);
     * @param user
     * @return
     */
    @RequestMapping("/cond2")
    public List<User> findByCondition2(@RequestBody User user){

        List<User> list =  userService.findByCondition2(user);

        return list;

    }






    //----------------------自定义mapper.xml配置方式


    @RequestMapping("/one2/{id}")
    public User findById2(@PathVariable Long id){

        return userService.findById(id);
    }

}
