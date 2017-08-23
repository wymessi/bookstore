package cn.hdu.web.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hdu.domain.Order;
import cn.hdu.domain.User;
import cn.hdu.service.impl.BusinessServiceImpl;

public class ListUserOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user=(User) request.getSession().getAttribute("user");
		if(user==null){
			request.setAttribute("message", "对不起，请先登陆!!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		BusinessServiceImpl service=new BusinessServiceImpl();
		List<Order> orderList=service.listAllOrder(user);
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("/client/listUserOrder.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
