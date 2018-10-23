package com.briup.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test1Servlet
 */
//@WebServlet("/One")
public class Test1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Cookie[] cookies = request.getCookies();
		String url = null;
		if(cookies!=null){
			String username = null;
			String password = null;
			for(Cookie cookie:cookies){
				String key = cookie.getName();//取值
				String value = cookie.getValue();
				if("name".equals(key)){
					username = value;//取出name的值
				}
				if("password".equals(value)){
					password = value;//取出password的值
				}
			}
			if(username!=null&&password!=null){
				url = "LoginServlet?username="+username+"&password="+password;
				System.out.println(url);
			}
			
		}else{
			url = "login.html";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
