package com.example.SpringSecurityRestAPI.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Để làm việc với Interceptor, bạn cần tạo
// @Component hỗ trợ nó và nó nên thực hiện interface HandlerInterceptor.
// tham khảo: https://www.tutorialspoint.com/spring_boot/spring_boot_interceptor.htm
@Component
public class BookInterceptor implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(BookInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("BookInterceptor - preHandle");
//		boolean flag = true;
//		String method = request.getMethod();
//		int contentLength =request.getContentLength();
//		if(method.equalsIgnoreCase("post") || method.equalsIgnoreCase("put")) {
//			String contentType = request.getContentType();
//			if(contentType != null && !contentType.equalsIgnoreCase("application/json")) {
//				flag = false;
//			}
//			else if(contentLength <= 2) {
//				flag = false;
//			}
//		}
//		if(!flag) {
//			response.sendRedirect("/rest/books/invalid");
//		}
//		return flag;
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.info("BookInterceptor - postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        log.info("BookInterceptor - afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
