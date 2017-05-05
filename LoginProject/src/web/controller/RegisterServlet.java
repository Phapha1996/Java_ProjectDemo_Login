package web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import exception.UserExistException;
import service.imple.BusinessServiceImpl;
import service_interface.BusinessService;
import utils.WebUtils;
import web.formbean.RegisterForm;

public class RegisterServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		request.setCharacterEncoding("UTF-8");
		
		//对表单数据进行合法性校验
		RegisterForm form = WebUtils.requestToBean(request, RegisterForm.class);		//把表单数据封装到formbean中
		/*String s1 = form.getBirthday();
		String s2 = form.getUsername();
		String s3 = form.getNickname();TEST*/
		
		/*类似以下功能:
		RegisterForm form = new RegisterForm();
	    form.setUsername(request.getParameter("username"));
		form.setPassword(request.getParameter("password"));
		form.setPassword2(request.getParameter("password2"));
		form.setEmail(request.getParameter("email"));
		form.setNickname((request.getParameter("nickname")));
		form.setBirthday(request.getParameter("birthday"));*/
		
			
		boolean b = form.validate();
			
			//如果校验失败，跳回表单页面，回显校验失败的信息
			if(!b){
				request.setAttribute("form", form);
				request.getRequestDispatcher("/WEB-INF/jsp/teachRegister.jsp").forward(request, response);
				return;
			}
		
//-------------------------------------------------------------------------------------------------------以上可以交给ajax		
		//如果校验成功，调用service层处理请求
		User user = new User(); 
		
		/**WebUtils.copyBean(form, user);*/
		WebUtils.bean1tobean2(user, form);		//copy两个bean的属性
		user.setId(WebUtils.generateID());
		BusinessService sb = new BusinessServiceImpl();
		try {
			sb.register(user);
		}
		catch (UserExistException e) {
			//如果service处理不成功，不成功的原因是因为用户已存在，跳回注册页面，显示用户已存在的消息
			request.setAttribute("message", "对不起，您输入的用户名已经存在！");
			request.setAttribute("Refresh", "<meta http-equiv='refresh' content='1;url="+this.getServletContext().getContextPath()+"/servlet/RegisterUIServlet'>本页面即将跳转注册。如果未跳转，请点击<a href='"+this.getServletContext().getContextPath()+"/servlet/RegisterUIServlet'>这里</a>");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		}
		catch(Exception e1){
			//如果service处理不成功，不成功的原因是因为其他问题，跳转到网站全局消息显示页面，为用户显示友好错误消息
			e1.printStackTrace();
			request.setAttribute("message", "对不起，服务器出现未知错误~");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		}
			
		
		request.setAttribute("message", "注册成功！！！");
		request.setAttribute("Refresh", "<meta http-equiv='refresh' content='1;url="+this.getServletContext().getContextPath()+"/servlet/LoginUIServlet'>本页面即将跳转登录。如果未跳转，请点击<a href='"+this.getServletContext().getContextPath()+"/servlet/LoginUIServlet'>这里</a>");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		return;
		
		//如果service处理成功，跳转到网站的全局消息显示页面，提示用户注册成功
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
 