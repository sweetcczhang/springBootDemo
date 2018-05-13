package cn.bupt.zcc.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 数据库连接配置
 * Created by 张城城 on 2018/5/13.
 */
@Configuration
@EnableTransactionManagement
@MapperScan("cn.bupt.zcc.mapper")
public class DataSourceConfig {
    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Autowired
    private Environment environment;

    @Autowired
    private PageInterceptor pageInterceptor;

    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)throws Exception{
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(dataSource);
        fb.setPlugins(new Interceptor[]{pageInterceptor});
        fb.setTypeAliasesPackage(environment.getProperty("mybatis.type-aliases-package"));
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(environment.getProperty("mybatis.mapper-locations")));
        return fb.getObject();
    }
}
