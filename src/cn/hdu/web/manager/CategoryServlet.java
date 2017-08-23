package cn.hdu.web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hdu.domain.Category;
import cn.hdu.service.impl.BusinessServiceImpl;
import cn.hdu.utils.WebUtils;

public class CategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");
		if ("addCategory".equals(method)) {

			this.add(request, response);

		} else if ("listAllCategory".equals(method)) {
			this.listAllCategory(request, response);
		}

	}

	private void listAllCategory(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			BusinessServiceImpl service = new BusinessServiceImpl();
			List<Category> categories = service.listAllCategory();
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/manager/listAllCategory.jsp")
					.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			Category category = new Category();
			category.setId(WebUtils.makeId());
			category.setName(name);
			category.setDescription(description);

			BusinessServiceImpl service = new BusinessServiceImpl();
			service.addCategory(category);
			request.setAttribute("message", "添加成功！！");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败！！");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
