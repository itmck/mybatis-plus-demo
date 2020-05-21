package com.itmck.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:book.properties")//指定要加载的配置文件
@ConfigurationProperties(prefix = "book")//可以指定前缀
@Data
public class Book {

    private String name;
    private String author;
    private String id;
}
