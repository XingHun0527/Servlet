package com.briup.bean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class TestOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=null;
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String autoLogin = request.getParameter("autoLogin");
		String zip=request.getParameter("zip");
		String address=request.getParameter("address");
		String telephone=request.getParameter("telephone");
		String email=request.getParameter("email");
		
		if(autoLogin!=null){
			Cookie cookie1=new Cookie("name",name);
			Cookie cookie2=new Cookie("password", password);
			Cookie cookie3=new Cookie("zip", zip);
			Cookie cookie4=new Cookie("address",address);
			Cookie cookie5=new Cookie("telephone", telephone);
			Cookie cookie6=new Cookie("email", email);
			
			cookie1.setMaxAge(60*60*24);
			cookie2.setMaxAge(60*60*24);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			response.addCookie(cookie4);
			response.addCookie(cookie5);
			response.addCookie(cookie6);
			
		}
		if(name!=null&&password!=null){
			url="login.html";
		}else{
			url="err.html";
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

