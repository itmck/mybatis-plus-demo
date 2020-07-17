package com.itmck.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itmck.dao.UserMapper;
import com.itmck.pojo.User;
import com.itmck.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Create by it_mck 2019/9/14 21:09
 *
 * @Description:
 * @Version: 1.0
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getLists() {

        List<User> users = null;
        users = userMapper.selectList(null);
        log.info("查询结果{}",users);
        return users;
    }


    @Override
    public User findById(Long id) {

        User user = userMapper.selectById(id);
        return user;
    }

    /**
     * SELECT id,name,email,age FROM user WHERE name = ? AND email = ?
     * 使用map拼接条件,其中key对应数据库中的字段
     *
     * @param user
     * @return
     */
    @Override
    public List<User> findByCondition(User user) {

        HashMap<String, Object> map = new HashMap<>();
        String name = user.getName();
        if (StringUtils.isNotBlank(name)) {
            map.put("name", name);
        }

        String email = user.getEmail();
        if (StringUtils.isNotBlank(email)) {
            map.put("email", email);
        }
        List<User> list = userMapper.selectByMap(map);
        return list;
    }

    /**
     * SELECT id,name,email,age FROM user WHERE (name = ? AND email = ?)
     * @param user
     * @return
     */
    @Override
    public List<User> findByCondition2(User user) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", user.getName());
        map.put("email", user.getEmail());
        map.put("age", user.getAge());
        map.put("id", user.getId());
        /**
         * 参数1:Map  参数2:boolean=true(不忽略为null的),false(忽略为null的字段)
         */
        userQueryWrapper.allEq(map, false);
        List<User> users = userMapper.selectList(userQueryWrapper);
        return users;
    }

    @Cacheable("users")
    @Override
    public User selectById(Long id) {

        return userMapper.findById(id);
    }
}
