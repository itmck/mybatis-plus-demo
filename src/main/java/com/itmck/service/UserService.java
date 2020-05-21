package com.itmck.service;

import com.itmck.pojo.User;

import java.util.List;

/**
 * Create by it_mck 2019/9/14 21:08
 *
 * @Description:
 * @Version: 1.0
 */
public interface UserService {
    /**
     *
     * @return 获取集合
     */
    List<User> getLists();


    /**
     * 根据主键查找
     * @param id
     * @return
     */
    User selectById(Long id);

    /**
     * 根据主键查找
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 条件查询
     * @param user
     * @return
     */
    List<User> findByCondition(User user);
    List<User> findByCondition2(User user);
}
