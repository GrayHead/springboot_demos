package ua.com.owu.springboot_demos.security.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CustomFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println(request.getHeader("custom"));
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.addHeader("Authorization", "you are");
        filterChain.doFilter(servletRequest, servletResponse);
    }


}
