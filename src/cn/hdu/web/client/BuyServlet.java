package cn.hdu.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hdu.domain.Book;
import cn.hdu.domain.Cart;
import cn.hdu.service.impl.BusinessServiceImpl;

public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String book_id = request.getParameter("book_id");
			BusinessServiceImpl service = new BusinessServiceImpl();
			Book book = service.findBook(book_id);
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			if(cart==null){
				cart=new Cart();
				request.getSession().setAttribute("cart", cart);
			}
			service.buyBook(cart,book);
			request.getRequestDispatcher("/client/listCart.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "¹ºÂòÊ§°Ü£¡£¡");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
