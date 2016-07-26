package com.joea.javaweb.bookstore.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joea.javaweb.bookstore.entity.BookEntity;
import com.joea.javaweb.bookstore.entity.Page;
import com.joea.javaweb.bookstore.service.BookService;
import com.joea.javaweb.bookstore.vo.Book;

/**
 * Servlet implementation class BookServlet
 */

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/***
	 * 按页获取book
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageNoStr = request.getParameter("pageNo");
		String minPriceStr = request.getParameter("minPriceStr");
		String maxPriceStr = request.getParameter("maxPriceStr");

		int pageNo = 1;
		int minPrice = 0;
		int maxPrice = Integer.MAX_VALUE;
		try {
			pageNo = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e) {
			pageNo = 1;
		}
		try {
			minPrice = Integer.parseInt(minPriceStr);
		} catch (NumberFormatException e) {
			minPrice = 0;
		}
		try {
			maxPrice = Integer.parseInt(maxPriceStr);
		} catch (NumberFormatException e) {
			maxPrice = Integer.MAX_VALUE;
		}

		BookEntity be = new BookEntity(minPrice, maxPrice, pageNo);
		Page<Book> page = bookService.getPage(be);
		// System.out.println(page.getList());
		request.setAttribute("bookpage", page);

		request.getRequestDispatcher("/WEB-INF/pages/book.jsp").forward(request, response);
	}

	/***
	 * 获取book的详细的信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	protected void getBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Book book = bookService.getBook(id);
		request.setAttribute("book", book);
		request.getRequestDispatcher("").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
