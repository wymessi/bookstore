package cn.hdu.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hdu.domain.User;
import cn.hdu.service.impl.BusinessServiceImpl;
import cn.hdu.utils.WebUtils;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String cellphone = request.getParameter("cellphone");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			User user = new User();
			user.setId(WebUtils.makeId());
			user.setUsername(username);
			user.setPassword(password);
			user.setPhone(phone);
			user.setCellphone(cellphone);
			user.setAddress(address);
			user.setEmail(email);

			BusinessServiceImpl service = new BusinessServiceImpl();
			service.register(user);
			request.setAttribute("message", "ע��ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "ע��ɹ�");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
