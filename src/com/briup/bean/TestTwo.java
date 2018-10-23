package com.briup.bean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToLoginServlet
 */
public class TestTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestTwo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String url=null;
		if(cookies!=null){
			String name=null;
			String password=null;
			for(Cookie cookie:cookies){
				String key=cookie.getName();
				String value=cookie.getValue();
				if("name".equals(key)){
					name=value;
				}
				if("password".equals(value)){
					password=value;
				}
			}
			if(name!=null&&password!=null){
				url="TestOne?name="+name+"&password="+password;
			}
		}else{
			url="login.html";
		}
		request.getRequestDispatcher(url).forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

