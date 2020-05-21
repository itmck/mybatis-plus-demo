package com.itmck.base.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by it_mck 2019/9/15 14:50
 *
 * @Description: 使用mybatis-plus分页的时候要设置此项
 * @Version: 1.0
 */

@Configuration
public class MybatisplusConfig {


    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {

        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // paginationInterceptor.setLimit(你的最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制);
        paginationInterceptor.setDialectType("mysql");//指定 MySQL 方言，否则它可能不知道怎么写分页函数
        return paginationInterceptor;
    }
}
