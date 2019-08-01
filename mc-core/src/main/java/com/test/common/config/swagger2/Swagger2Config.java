package com.test.common.config.swagger2;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Project: common
 * Package: com.test.common.config.swagger2
 * Description: ...
 * <p>
 * @author zhaozhe
 * Data: 2019-7-31
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                        .select()
                        .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                        .apis(RequestHandlerSelectors.basePackage("com.test"))
                        .paths(PathSelectors.any())
                        .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口平台")
                .description("1：代码必须有规范的注释，Bean对象字段有简洁，高阅读性的说明，每个人安装阿里巴巴代码检查插件，排除基础格式性的错误。\n" +
                        "2：对象的get，set等方法，统一使用Lombok的注解，简化代码。\n" +
                        "3：常用方法，统一使用ToolUtil工具类，所有人慢慢完善这个工具类，统一管理。\n" +
                        "4：Sql语句必须格式化，提高阅读性，简化排错效率，为以后做准备。\n" +
                        "5：所有人的update，insert，delete相关接口，必须保证有规范，流程的日志输出。\n" +
                        "6：接口如果为Post，避免使用@RequestParam，除非你标明每个参数的意思，要不就使用@RequestBody，在对象中也要把字段加上注释。\n" +
                        "7：HttpUtil工具包，统一使用Hutool包，内含其他很多常用工具方法，不要每个人的项目都自己封装。\n" +
                        "8：修改他人代码要在开头和结尾加入注释. 例:/**孙强 2018-9-26 16:08:22 修改七师自提单错误问题 start */  开始\n" +
                        "  修改他人代码要在开头和结尾加入注释. 例:/** 孙强 2018-9-26 16:08:22 修改七师自提单错误问题 end */    结束\n")
                .version("版本号：1.0.1")
                .build();
    }
}
