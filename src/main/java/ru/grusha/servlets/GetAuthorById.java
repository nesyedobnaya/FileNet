package main.java.ru.grusha.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAuthorById
 * Сервлет, получающий id автора и открывающий страницу с документами автора
 */
@WebServlet("/GetAuthorById")
public class GetAuthorById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAuthorById() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Метод получает id автора
	 * записывает id в атрибут
	 * открывает страницу с документами автора
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String chosenAuthorId = request.getParameter("authorId");
		request.setAttribute("chosenAuthorId", chosenAuthorId);
		request.getRequestDispatcher("documents.jsp").forward(request, response);
	}
}
