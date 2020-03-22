package com.ps.tools;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.StringUtils;
import com.ps.vo.ResultVO;

/**
 * 系统过滤器
 * @author admin
 *
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
	
	//哪些后台服务需要进行token验证（需要登录后才能访问）
	private String[] urls = new String[] {"/queryCartOrdersByUid","/placeOrder"};
	
	//允许跨域的地址集合
	//private String[] Domains = new String[] {"http://localhost:8081","http://192.168.0.0.1:8081"};
	
/*	//过滤关键字配置
	private List<SysDataDictionaryVO> filterCodes = null;*/
	
/*	*//**
	 * 数据字典服务
	 *//*
	private ISysDataDictionaryService dataDictionaryService;*/

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//获取session
		HttpServletRequest httpRequest=(HttpServletRequest)request;
        HttpServletResponse httpResponse=(HttpServletResponse)response;
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
        //请求地址
        String uri = httpRequest.getRequestURI();
        
        System.out.println(uri);
        //判断是否属于需要过滤的资源
        boolean pass = false;
        if(urls != null){        	
        	for (int i = 0; i < urls.length; i++) {
        		if (uri.indexOf(urls[i])>-1){
        			pass = true;
        			break;
        		}
			}
        }
        if (pass == true) {//需要登录之后才能访问
        	ResultVO<?> result = new ResultVO<>();
        	//验证token的合法性
            String accessToken = httpRequest.getHeader("Authorization");
            if (!StringUtils.isNullOrEmpty(accessToken)) {
            	boolean bool = JwtUtil.isValid(accessToken);
            	if (bool == true) {
            		//token验证通过
            		chain.doFilter(request, response);
            	} else {
            		//告诉调用者，token验证不通过
            		result.setCode("101");
            		result.setMsg("token Validation Failure");
            		String json = JSONObject.toJSONString(result);
            		httpResponse.setHeader("noAuthorization", "true");
    				httpResponse.setContentType("application/json;charset=UTF-8");  
    				PrintWriter pw  = httpResponse.getWriter();
    				pw.write(json);
    				
    				pw.close();
            	}
            } else {
            	result.setCode("102");
        		result.setMsg("token is null");
        		String json = JSONObject.toJSONString(result);
        		httpResponse.setHeader("noAuthorization", "true");
				httpResponse.setContentType("application/json;charset=UTF-8");  
				PrintWriter pw  = httpResponse.getWriter();
				pw.write(json);
				
				pw.close();
            }
        } else {
        	//正常请求
        	chain.doFilter(request, response);
        }
       
	}
	
	
	/**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
