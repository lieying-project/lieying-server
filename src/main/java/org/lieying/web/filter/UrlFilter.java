package org.lieying.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UrlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;



        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        // 如果不是80端口,需要将端口加上,如果是集群,则用Nginx的地址,同理不是80端口要加上端口
        String []  allowDomain= {"http://127.0.0.1:8084"};
        Set allowedOrigins= new HashSet(Arrays.asList(allowDomain));

        String originHeader=((HttpServletRequest) request).getHeader("Origin");
        if (allowedOrigins.contains(originHeader)){
            System.out.println(originHeader);
            httpResponse.setHeader("Access-Control-Allow-Origin", originHeader);
            httpResponse.setContentType("application/json;charset=UTF-8");
            httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            httpResponse.setHeader("Access-Control-Max-Age", "3600");
            httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type,token");
            // 如果要把Cookie发到服务器，需要指定Access-Control-Allow-Credentials字段为true
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpResponse.setHeader("Access-Control-Expose-Headers", "Content-Type,token");
        }
        String host=request.getHeader("Host");
        System.out.println("Host:"+host);
        String port=request.getHeader("Port");
        System.out.println("port:"+port);
        String token=request.getHeader("token");
        System.out.println(token);
        //放行 options 的请求
        if ("OPTIONS".equals(request.getMethod())) {
            chain.doFilter(request, servletResponse);
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
