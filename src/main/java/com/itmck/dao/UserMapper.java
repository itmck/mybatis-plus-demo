package com.itmck.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itmck.base.utils.PageParam;
import com.itmck.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by it_mck 2019/9/14 20:58
 *
 * @Description: 使用Mybatis-plus通用mapper
 * @Version: 1.0
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User findById(@Param("id") Long id);

    /**
     * 分页
     * @param pageParam
     * @return
     */
    List<User> findAllByPage(PageParam pageParam);
}
