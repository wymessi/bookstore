package cn.hdu.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hdu.domain.User;
import cn.hdu.service.impl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		BusinessServiceImpl service=new BusinessServiceImpl();
		User user=service.login(username, password);
		if(user==null){
			request.setAttribute("message", "�û�����������󣡣���");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("/client/head.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
