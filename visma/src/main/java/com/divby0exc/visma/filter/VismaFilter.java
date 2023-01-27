package com.divby0exc.visma.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class VismaFilter extends OncePerRequestFilter {

        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            if(request.getSession().getAttribute("username") != null) {
                filterChain.doFilter(request, response);
            } else {
                response.sendRedirect("/authentication/login");
            }
        }

        @Override
        protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
            System.out.println(request.getServletPath());
            return request.getServletPath().contains("/"); //e.g. login page
        }
    }
