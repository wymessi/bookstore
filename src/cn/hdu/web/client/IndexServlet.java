package cn.hdu.web.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hdu.domain.Book;
import cn.hdu.domain.Category;
import cn.hdu.domain.Page;
import cn.hdu.service.impl.BusinessServiceImpl;

public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if ("getAll".equals(method)) {

			this.getAllBook(request, response);

		}else if("listBookWithCategory".equals(method)){
			this.listBookWithCategory(request, response);
		}
		
	}

	private void listBookWithCategory(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			BusinessServiceImpl service = new BusinessServiceImpl();
			String pageNum=request.getParameter("pageNum");
			String category_id=request.getParameter("category_id");
			Page page = service.getPage(pageNum, category_id);
			request.setAttribute("page", page);
			List<Category> categories = service.listAllCategory();
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/client/listBook.jsp").forward(
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getAllBook(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			BusinessServiceImpl service = new BusinessServiceImpl();
			String pageNum=request.getParameter("pageNum");
			
			Page page = service.getPage(pageNum);
			request.setAttribute("page", page);
			List<Category> categories = service.listAllCategory();
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/client/listBook.jsp").forward(
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
