package com.briup.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="/TestOne",value="/One")
public class TestOne extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//接受请求
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		String zip=req.getParameter("zip");

		System.out.println("姓名:"+name);
		System.out.println("密码:"+password);
		System.out.println("性别:"+gender);
		System.out.println("邮箱:"+zip);
		
		//根据请求做出响应
		
		
		//设置编码格式
		resp.setCharacterEncoding("UTF-8");
		//告诉浏览器解析编码格式
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("UTF-8");
		
		PrintWriter pWriter=resp.getWriter();
		if("111".equals(name)&&"111".equals(password)){
			
			PrintWriter printWriter=resp.getWriter();
			String basepath=req.getRealPath("/");
			File file=new File(basepath+"login.html");
			
			
				String name1=req.getParameter("name");
				String password1=req.getParameter("password");
				
				BufferedReader bReader=new BufferedReader(new FileReader(file));
				String line=null;
				while((line=bReader.readLine())!=null){
					printWriter.write(line);
					printWriter.flush();	
				
				}
				bReader.close();
				printWriter.close();	
				
					

			/*if("111".equals(name)&&"111".equals(password)){
				resp.sendRedirect(req.getContextPath()+"success.html");
			}else{
				resp.sendRedirect(req.getContextPath()+"err.html");
			}*/
			}else{
			
			PrintWriter printWriter=resp.getWriter();
			String basepath=req.getRealPath("/");
			File file=new File(basepath+"register.html");
			BufferedReader bReader=new BufferedReader(new FileReader(file));
			String line=null;
			while((line=bReader.readLine())!=null){
				printWriter.write(line);
				printWriter.flush();
			}
			bReader.close();
			printWriter.close();
			}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}	












/*if(name1.equals(name)&&password1.equals(password)){
	
	PrintWriter printWriter1=resp.getWriter();
	String basepath1=req.getRealPath("/");
	File file1=new File(basepath+"success.html");
	BufferedReader bReader1=new BufferedReader(new FileReader(file1));
	String line1=null;
	while((line1=bReader1.readLine())!=null){
		printWriter.write(line1);
		printWriter.flush();	
	
	}
	
	bReader1.close();
	printWriter1.close();
}else{
	PrintWriter printWriter2=resp.getWriter();
	String basepath2=req.getRealPath("/");
	File file2=new File(basepath+"err.html");
	BufferedReader bReader2=new BufferedReader(new FileReader(file2));
	String line2=null;
	while((line2=bReader2.readLine())!=null){
		printWriter.write(line2);
		printWriter.flush();
	}
	bReader2.close();
	printWriter2.close();
	}*/