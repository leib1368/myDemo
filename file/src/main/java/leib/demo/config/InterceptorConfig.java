package leib.demo.config;

import leib.demo.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author:Leib
 * @Date 2020/5/17 13:58
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Value("${upload.dir}")
    private String upload;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/file/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**");//放行静态资源 静态资源被认为是一个控制器请求
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**") //代表以什么样的请求路径访问静态资源
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/templates/")
                .addResourceLocations("file:"+upload);//本地资源路径必须放在最上面

    }
}
