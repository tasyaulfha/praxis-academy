package com.example.bankmanagement.config;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)  {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        response.setHeader("ACCESS-CONTROL-ALLOW-ORIGIN", "http://localhost:8082");
        response.setHeader("Access-Control-Allow-Methods", "POST,PUT,GET,OPTIONS,DELETE");
        response.setHeader("Access-Control-Allow-Headers","x-requested-with");
        response.setHeader("Access-Controll-Max-Age","3600");
        response.setHeader("Access-Controll-Allow-Credentials","true");

        if (!(request.getMethod().equalsIgnoreCase("OPTIONS"))){
            try {
                filterChain.doFilter(servletRequest,servletResponse);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            System.out.println("Pre-flight");
            response.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE");
            response.setHeader("Access-Control-Max-Age","3600");
            response.setHeader("Access-Control-Allow-Headers","authorization, content-type"+
                    "access-control-request-headers,access-control-request-method,accept,origin,authorization" +
                    ",x-requested-with");
            response.setStatus(HttpServletResponse.SC_OK);

        }

    }

    public void init(FilterConfig filterConfig){

    }

    public void destroy(){}
}
