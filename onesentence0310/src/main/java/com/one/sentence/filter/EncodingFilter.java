package com.one.sentence.filter;

import javax.servlet.Filter;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{

	    protected FilterConfig filterConfig;

	    public void init(FilterConfig filterConfig) throws ServletException{
	        this.filterConfig = filterConfig;
	    } 

	    public void doFilter(ServletRequest request, ServletResponse response,
	            FilterChain chain) throws IOException, ServletException {
	        if (request.getCharacterEncoding() == null) {
	            String encoding = filterConfig.getInitParameter("encoding");
	            if (encoding != null) {
	                request.setCharacterEncoding(encoding);
	            }
	        }
	        chain.doFilter(request, response);
	    }

	    public void destroy() {
	        this.filterConfig = null;
	    }
	}

