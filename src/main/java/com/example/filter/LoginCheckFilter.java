package com.example.filter;

import com.alibaba.fastjson.JSON;
import com.example.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * 检查用户是否已经完成登录
 */
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    // 路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取本次请求的URI
        String requestURI = request.getRequestURI(); //localhost:8081/backend/login_sample.html
        // 定义不需要处理的请求路径
        String[] urls = new String[]{
                "/user/login",
                "/user/logout",
                "/backend/**",
                "/front/**",
                "/common/**"
        };
        // 判断本次请求是否需要处理
        boolean check = check(urls,requestURI);
        // 如果不需要处理，则直接放行
        if(check){
            filterChain.doFilter(request,response);
            return;
        }
        // 判断登录状态，如果已登录，则直接放行
        if(request.getSession().getAttribute("user")!=null){
            log.info("已登录，不需要处理");
            filterChain.doFilter(request,response);
            return;
        }
        // 未登录则返回未登录结果
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;

    }

    /**
     * 路径匹配，检查本次请求是否需要放行
     * @param urls
     * @param requsetURI
     * @return true or false
     */
    public boolean check(String[] urls,String requsetURI){
        for(String url:urls){
            boolean match = PATH_MATCHER.match(url, requsetURI);
            if(match){
                return true;
            }
        }
        return false;
    }


}
