package cn.hdu.web.manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.hdu.domain.Book;
import cn.hdu.domain.Category;
import cn.hdu.domain.Page;
import cn.hdu.service.impl.BusinessServiceImpl;
import cn.hdu.utils.WebUtils;

public class BookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("addBook".equals(method)) {

			this.addBook(request, response);

		} else if ("listAllBook".equals(method)) {
			this.listAllBook(request, response);
		} else if ("addUI".equals(method)) {
			this.addUI(request, response);
		}
	}

	private void addUI(HttpServletRequest request, HttpServletResponse response) {

		try {
			BusinessServiceImpl service = new BusinessServiceImpl();
			List<Category> categories = service.listAllCategory();
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/manager/addBook.jsp").forward(
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void listAllBook(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			
			String pageNum=request.getParameter("pageNum");
			BusinessServiceImpl service = new BusinessServiceImpl();
			Page page=service.getPage(pageNum);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/manager/listAllBook.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private void addBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			Book book=new Book();
			DiskFileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			if(!upload.isMultipartContent(request)){
				return;
			}
			List<FileItem> list=upload.parseRequest(request);
			for(FileItem item:list){
				if(item.isFormField()){
					String name=item.getFieldName();
					String value=item.getString("UTF-8");
					BeanUtils.setProperty(book, name, value);
				}else{
					String filename=item.getName();
					String saveFilename = makeFileName(filename);
					String savePath=this.getServletContext().getRealPath("/images");
					
					InputStream in=item.getInputStream();
					FileOutputStream out=new FileOutputStream(new File(savePath+File.separator+saveFilename));
					byte b[]=new byte[1024];
					int len=0;
					while((len=in.read(b))>0){
						out.write(b, 0, len);
					}
					in.close();
					out.close();
					item.delete();
					book.setImage(saveFilename);
				}
			}
			BusinessServiceImpl service=new BusinessServiceImpl();
			book.setId(WebUtils.makeId());
			service.addBook(book);
			request.setAttribute("message", "添加成功！！");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败！！");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private String makeFileName(String filename) {
		String ext=filename.substring(filename.lastIndexOf("."));
		return UUID.randomUUID().toString()+ext;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
