package org.noedge.web.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:跨域访问过滤器
 */
public class CORSFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("servletRequest.encoding" + servletRequest.getCharacterEncoding());
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        ResponseHeader.addHeader(response);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
