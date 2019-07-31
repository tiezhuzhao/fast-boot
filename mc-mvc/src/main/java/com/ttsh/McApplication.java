package com.ttsh;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/**
 * Project: mc
 * Package: com.ttsh.mc
 * 启动类
 * @author zhaozhe
 * 1、阅读《阿里巴巴Java开发规范》，统一代码开发规范
 * 2、下载idea插件 Alibaba Java Coding Guidelines，可规范Java代码
 * 3、不要删除或更改mybatis generator生成的实体类、实体类属性、DAO接口、DAO的xml映射文件，可以新增自己写的方法
 * 4、当对已在本接口平台映射的数据库表字段进行新增、更改、删除时，应及时将变更添加到mybatis generator生成的实体类、DAO接口、DAO的xml映射文件中
 * 5、任何创建的类和方法都要有注释，注释包括但不限于：创建人、用途、创建时间
 * 6、项目使用的maven版本：3.0以上 spring-boot版本：2.0以上
 * 7、项目使用的idea应为2017以后的版本，2017之前的版本编译项目会报错，周知
 * @date 2019-7-31
 */
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = {"com.ttsh.**.mapper"})
public class McApplication extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(McApplication.class);

    public static void main(String[] args) {
        logger.info("接口服务启动");
        SpringApplication.run(McApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(McApplication.class);
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}