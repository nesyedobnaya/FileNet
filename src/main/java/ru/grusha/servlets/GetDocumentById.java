package main.java.ru.grusha.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDocumentById
 * Сервлет, получающий id документа и открывающий страницу с полями документа
 */
@WebServlet("/GetDocumentById")
public class GetDocumentById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetDocumentById() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Метод получает id документа
	 * записывает id в атрибут
	 * открывает страницу с полями документа
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String chosenDocumentId = request.getParameter("documentId");
		request.setAttribute("chosenDocumentId", chosenDocumentId);
		request.getRequestDispatcher("documentContent.jsp").forward(request, response);
	}
}
