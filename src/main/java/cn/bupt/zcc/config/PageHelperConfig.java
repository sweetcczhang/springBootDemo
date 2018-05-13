package cn.bupt.zcc.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 分页插件PageHelper的配置
 * Created by 张城城 on 2018/5/13.
 */
@Configuration
public class PageHelperConfig {
    @Value("${pagehelper.helperDialect}")
    private String helperDialect;

    @Bean
    public PageInterceptor pageInterceptor(){
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect",helperDialect);
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
