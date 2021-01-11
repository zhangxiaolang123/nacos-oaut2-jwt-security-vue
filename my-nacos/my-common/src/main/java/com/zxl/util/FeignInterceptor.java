package com.zxl.util;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 描述(hystrix 必须是设置为信号量模式)
 *
 * @author zxl
 * @version 1.0
 * @since 1.0
 */
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //fegin之间的调用，把请求头传给下一个（主要是把authorization往下传）
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            //1.获取请求对象
            HttpServletRequest request = requestAttributes.getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();
            if (headerNames != null) {
                //2.获取请求对象中的所有的头信息(网关传递过来的)
                while (headerNames.hasMoreElements()) {
                    String name = headerNames.nextElement();//头的名称
                    String value = request.getHeader(name);//头名称对应的值
                    System.out.println("name:" + name + "::::::::value:" + value);
                    //3.将头信息传递给fegin (restTemplate)
                    requestTemplate.header(name,value);
                }
            }
        }


    }
}
