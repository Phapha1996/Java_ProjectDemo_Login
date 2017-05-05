package web.UIservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoffServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		session.removeAttribute("user");
		request.setAttribute("logoffmessage", "您好，您还未登录，请您先<a href='"+this.getServletContext().getContextPath()+"/servlet/LoginServlet'>登录</a>才能享有我站资源服务！");
		request.getRequestDispatcher("/WEB-INF/jsp/Main.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
		}

}
