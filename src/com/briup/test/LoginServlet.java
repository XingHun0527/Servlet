package com.briup.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
//@WebServlet("/One")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//String gender = request.getParameter("gender");
		if("xzx".equals(username)&&"123".equals(password)){
			//���û���������session��
			//1.��ȡsession����
			HttpSession session = request.getSession();
			//2.���û���������session��
			//session.setAttribute("userid", userid);
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			//session.setAttribute("gender", gender);
			//��ת���û���ҳ
			response.sendRedirect(request.getContextPath()+"LoginServlet");
		}else{
			//��¼ʧ�ܣ�Ҫ���ض���
			response.sendRedirect(request.getContextPath()+"error.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
