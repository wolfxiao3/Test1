package com.AbuOnlineShopping.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	protected String encoding = null;
	protected FilterConfig filterConfig = null;
	protected boolean ignore = true;
@Override
	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}
@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {
		if(ignore||(request.getCharacterEncoding()==null)){
			request.setCharacterEncoding(selectEncoding(request));
		}
		chain.doFilter(request, response);

	}
@Override	
	public void init(FilterConfig filterConfig){
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
		String value = filterConfig.getInitParameter("ignore");
		if(value == null){
			this.ignore = true;
		}
		else if(value.equalsIgnoreCase("true")||value.equalsIgnoreCase("yes"))
			this.ignore = true;
		else 
			this.ignore = false;
		
	}

	private String selectEncoding(ServletRequest request) {
		return (this.encoding);
	}
	
	public FilterConfig getFilterConfig(){
		return filterConfig;
	}
	
	public void setFilterConfig(FilterConfig filterConfig){
		this.filterConfig = filterConfig;
	}


	

}
