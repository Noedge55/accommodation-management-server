package org.noedge.web.filter;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 */
public class ResponseHeader {
    public static HttpServletResponse addHeader(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Credentials","true");
        response.addHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8080");
        response.setHeader("Access-Control-Allow-Headers","origin,X-Requested-with,content-type,token");
        response.setHeader("Access-Control-Allow-Methods","GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH");
        response.setContentType("application/json"); //设置返回数据结构为json类型
        response.setCharacterEncoding("UTF-8");      //设置字符格式，防止中文乱码
        return response;
    }
}
