package top.bigking.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import top.bigking.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: ABKing
 * @Date: 2019/12/29 20:25
 * @Description:
 **/
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求路径
        String uri = request.getRequestURI();
        // 第一步：先要判断请求的地址，如果是/auth或者/logout 跳过拦截
        if(uri.endsWith("/logout") || uri.endsWith("auth")) {
            return true;
        }
        // 第二步：如果请求地址是login，要判断，
        // 如果已经登录那么直接跳转到登录后的界面
        if (uri.endsWith("login")) {
            User user = (User)request.getSession().getAttribute("user");
            if (user == null) {
                return true;
            }
            // 如果loginUser有值,跳转到登录后main页面
            response.sendRedirect("main");
            return false;
        }
        // 第三步：如果是其他地址，
        // 就要判断用户必须要登录，否则跳转到登录界面
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("login");
            return false;
        }
        return true;
    }
}
