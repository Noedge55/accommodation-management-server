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
        ResponseHeader.addHeader(response);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
