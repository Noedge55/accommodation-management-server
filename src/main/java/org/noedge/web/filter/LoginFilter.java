package org.noedge.web.filter;

import com.alibaba.fastjson.JSON;
import org.noedge.domain.LoginStatus;
import org.noedge.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 */
public class LoginFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        logger.info("--------------sessionId:"+request.getRequestedSessionId() + "-------------------");
        String path = request.getServletPath();
        PrintWriter out = null;
        try {
            int loginStatus = 0;
            if(path.toLowerCase().indexOf("login") != -1){
                filterChain.doFilter(request,response);
                loginStatus = 2;
            }else {
                HttpSession session = request.getSession();
                Object object = session.getAttribute(session.getId());
                if(null != object){
                    filterChain.doFilter(request,response);
                    loginStatus = 1;
                }
            }
            if(loginStatus == 0){
                out = response.getWriter();
//                Map<String,Integer> map = new HashMap<String, Integer>();
//                map.put("is_login", LoginStatus.NOT_LOGGED_IN);
                out.write(JSON.toJSONString(Result.getResult(-999,"未登录",null)));
            }
        }finally {
            if(null != out){
                out.flush();
                out.close();
            }
        }
    }

    public void destroy() {

    }
}
