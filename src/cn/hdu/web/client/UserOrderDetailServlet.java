package cn.hdu.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hdu.domain.Order;
import cn.hdu.service.impl.BusinessServiceImpl;

public class UserOrderDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String order_id=request.getParameter("order_id");
		BusinessServiceImpl service=new BusinessServiceImpl();
		Order order=service.findOrder(order_id);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/client/userOrderDetail.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
