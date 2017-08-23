package cn.hdu.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hdu.domain.Book;
import cn.hdu.domain.Cart;
import cn.hdu.domain.User;
import cn.hdu.service.impl.BusinessServiceImpl;

public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			User user=(User) request.getSession().getAttribute("user");
			if(user==null){
				request.setAttribute("message", "�Բ������ȵ�½!!");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			Cart cart=(Cart) request.getSession().getAttribute("cart");
			BusinessServiceImpl service=new BusinessServiceImpl();
			service.createOrder(user,cart);
			request.setAttribute("message", "���������ɣ���׼����Ǯ�ջ�����");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "��������ʧ�ܣ���");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
