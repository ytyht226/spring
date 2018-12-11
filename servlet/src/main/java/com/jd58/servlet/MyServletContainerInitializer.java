package com.jd58.servlet;

import com.jd58.service.HelloService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by yht on 2018/12/11.
 */
@HandlesTypes(value = {HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("the interested event: ");
        for (Class clazz : c) {
            System.out.println(clazz);
        }

        ServletRegistration.Dynamic servlet = ctx.addServlet("userServlet", new UserServlet());
        servlet.addMapping("/user");

        ctx.addListener(UserListener.class);

        FilterRegistration.Dynamic filter = ctx.addFilter("userFilter", UserFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}