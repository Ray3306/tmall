package com.ps.tools;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		//获取session
		HttpServletRequest httpRequest=(HttpServletRequest)arg0;
        HttpServletResponse httpResponse=(HttpServletResponse)arg1;
      //获取访问的Origin
        String myOrigin = httpRequest.getHeader("Origin");
        if (myOrigin != null) {
        	//设置跨域请求
	        httpResponse.setHeader("Access-Control-Allow-Origin", myOrigin);
	        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,	PUT");
	        httpResponse.setHeader("Access-Control-Max-Age", "3600");
	        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,Authorization");
	        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
	        httpResponse.setHeader("XDomainRequestAllowed","1");
        
        }
        System.out.println("MyFilter====================");
        chain.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
