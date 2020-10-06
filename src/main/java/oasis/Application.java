package oasis;

import oasis.filter.CrosFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("本项目默认关闭项目启动初始化数据功能，请从oasis.sql导入数据，\n如果想项目启动初始化数据，请打开application.java中main中的注释，\n从oasis.sql中找出建表语句并在本地建表");
        System.out.println("由于本项目使用了kmeans聚类做相关作者推荐，模型训练时间过长，不推荐本地初始化");
        System.out.println("具体说明详见部署文档");
//        System.out.println("数据初始化···");
//        InitMySQL initMySQL = new InitMySQL();
//        initMySQL.start();
//        System.out.println("初始化完毕···");
        System.out.println("启动成功！");
    }

    /**
     * 配置跨域访问的过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean registerFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.addUrlPatterns("/*");
        bean.setFilter(new CrosFilter());
        return bean;
    }

}
