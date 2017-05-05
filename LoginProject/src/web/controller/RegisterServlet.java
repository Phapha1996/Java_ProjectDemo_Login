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
		
		//�Ա����ݽ��кϷ���У��
		RegisterForm form = WebUtils.requestToBean(request, RegisterForm.class);		//�ѱ����ݷ�װ��formbean��
		/*String s1 = form.getBirthday();
		String s2 = form.getUsername();
		String s3 = form.getNickname();TEST*/
		
		/*�������¹���:
		RegisterForm form = new RegisterForm();
	    form.setUsername(request.getParameter("username"));
		form.setPassword(request.getParameter("password"));
		form.setPassword2(request.getParameter("password2"));
		form.setEmail(request.getParameter("email"));
		form.setNickname((request.getParameter("nickname")));
		form.setBirthday(request.getParameter("birthday"));*/
		
			
		boolean b = form.validate();
			
			//���У��ʧ�ܣ����ر�ҳ�棬����У��ʧ�ܵ���Ϣ
			if(!b){
				request.setAttribute("form", form);
				request.getRequestDispatcher("/WEB-INF/jsp/teachRegister.jsp").forward(request, response);
				return;
			}
		
//-------------------------------------------------------------------------------------------------------���Ͽ��Խ���ajax		
		//���У��ɹ�������service�㴦������
		User user = new User(); 
		
		/**WebUtils.copyBean(form, user);*/
		WebUtils.bean1tobean2(user, form);		//copy����bean������
		user.setId(WebUtils.generateID());
		BusinessService sb = new BusinessServiceImpl();
		try {
			sb.register(user);
		}
		catch (UserExistException e) {
			//���service�����ɹ������ɹ���ԭ������Ϊ�û��Ѵ��ڣ�����ע��ҳ�棬��ʾ�û��Ѵ��ڵ���Ϣ
			request.setAttribute("message", "�Բ�����������û����Ѿ����ڣ�");
			request.setAttribute("Refresh", "<meta http-equiv='refresh' content='1;url="+this.getServletContext().getContextPath()+"/servlet/RegisterUIServlet'>��ҳ�漴����תע�ᡣ���δ��ת������<a href='"+this.getServletContext().getContextPath()+"/servlet/RegisterUIServlet'>����</a>");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		}
		catch(Exception e1){
			//���service�����ɹ������ɹ���ԭ������Ϊ�������⣬��ת����վȫ����Ϣ��ʾҳ�棬Ϊ�û���ʾ�Ѻô�����Ϣ
			e1.printStackTrace();
			request.setAttribute("message", "�Բ��𣬷���������δ֪����~");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		}
			
		
		request.setAttribute("message", "ע��ɹ�������");
		request.setAttribute("Refresh", "<meta http-equiv='refresh' content='1;url="+this.getServletContext().getContextPath()+"/servlet/LoginUIServlet'>��ҳ�漴����ת��¼�����δ��ת������<a href='"+this.getServletContext().getContextPath()+"/servlet/LoginUIServlet'>����</a>");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		return;
		
		//���service����ɹ�����ת����վ��ȫ����Ϣ��ʾҳ�棬��ʾ�û�ע��ɹ�
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
 