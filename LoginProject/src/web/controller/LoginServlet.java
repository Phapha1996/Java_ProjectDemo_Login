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
		//�õ��û����˺����룬���Ҷ������У��
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//����û������룬��ת�ص���ǰҳ��
		boolean b = true;
		if(username==null||username.trim().equals("")){
			request.setAttribute("error1", "�û�������Ϊ�գ�");
			b = false;
		}else if(password==null||password.trim().equals("")){
			request.setAttribute("error2", "���벻��Ϊ�գ�");
			b = false;
		}
		
		if(b==false){
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}
			//���У��ͨ�������¼
		BusinessService sb = new BusinessServiceImpl();
		User user = sb.login(username, password);
		
		//�����¼ʧ�ܣ���תʧ�ܽ���
		if(user==null){
			request.setAttribute("message", "��������˺Ż������벻���ڣ�");
			request.setAttribute("Refresh", "<meta http-equiv='refresh' content='1;url="+this.getServletContext().getContextPath()+"/servlet/LoginUIServlet'>��ҳ�漴����ת��¼�����δ��ת������<a href='"+this.getServletContext().getContextPath()+"/servlet/LoginUIServlet'>����</a>");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
			
		}
		
		//�����¼�ɹ�����ô����ʾ�ɹ���¼��Ϣ��������ת��һ����ҳ��
		request.setAttribute("message", "��¼�ɹ���");
		request.setAttribute("Refresh","<meta http-equiv='refresh' content='1;url="+this.getServletContext().getContextPath()+"/servlet/MainUIServlet'>��ҳ�漴����ת��ҳ�����δ��ת������<a href='"+this.getServletContext().getContextPath()+"/servlet/MainUIServlet'>����</a>");
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		}

}
