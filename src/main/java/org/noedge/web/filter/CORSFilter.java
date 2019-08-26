package org.noedge.web.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:跨域访问过滤器
 */
public class CORSFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.addHeader("Access-Control-Allow-Credentials","true");
        response.addHeader("Access-Control-Allow-Origin", "http://192.168.50.153:8080");
        response.setHeader("Access-Control-Allow-Headers","origin,X-Requested-with,content-type,token");
        response.setHeader("Access-Control-Allow-Methods","GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH");
        response.setContentType("application/json"); //设置返回数据结构为json类型
        response.setCharacterEncoding("UTF-8");      //设置字符格式，防止中文乱码
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
