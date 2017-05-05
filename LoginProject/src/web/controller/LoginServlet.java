package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.imple.BusinessServiceImpl;
import service_interface.BusinessService;

public class LoginServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		request.setCharacterEncoding("UTF-8");
		//得到用户的账号密码，并且对其进行校验
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//如果用户乱输入，跳转回到当前页面
		boolean b = true;
		if(username==null||username.trim().equals("")){
			request.setAttribute("error1", "用户名不能为空！");
			b = false;
		}else if(password==null||password.trim().equals("")){
			request.setAttribute("error2", "密码不能为空！");
			b = false;
		}
		
		if(b==false){
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}
			//如果校验通过，则登录
		BusinessService sb = new BusinessServiceImpl();
		User user = sb.login(username, password);
		
		//如果登录失败，跳转失败界面
		if(user==null){
			request.setAttribute("message", "您输入的账号或者密码不存在！");
			request.setAttribute("Refresh", "<meta http-equiv='refresh' content='1;url="+this.getServletContext().getContextPath()+"/servlet/LoginUIServlet'>本页面即将跳转登录。如果未跳转，请点击<a href='"+this.getServletContext().getContextPath()+"/servlet/LoginUIServlet'>这里</a>");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
			
		}
		
		//如果登录成功，那么就提示成功登录消息，并且跳转到一个主页上
		request.setAttribute("message", "登录成功！");
		request.setAttribute("Refresh","<meta http-equiv='refresh' content='1;url="+this.getServletContext().getContextPath()+"/servlet/MainUIServlet'>本页面即将跳转主页。如果未跳转，请点击<a href='"+this.getServletContext().getContextPath()+"/servlet/MainUIServlet'>这里</a>");
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		}

}
