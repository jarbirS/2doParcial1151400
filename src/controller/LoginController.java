package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import dao.TiendaDao;
import dto.Cliente;
import dto.Tienda;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		TiendaDao tDao = new TiendaDao();
		ClienteDao cDao = new ClienteDao();
		switch (accion) {
		case "ingreso":
			String email = request.getParameter("email");
			String password = request.getParameter("pass");

			

			try {
				Tienda t = tDao.findByEmail(email);
				if (t != null) {
					if (t.getClave().equals(password)) {
						request.getSession().setAttribute("tienda", t);
						request.getRequestDispatcher("/JSP/servicios.jsp").forward(request, response);
					} else {
						response.sendRedirect(request.getContextPath() + "/JSP/login.jsp");
					}
				}
			} catch (Exception e) {
				try {
					Cliente c = cDao.findByEmail(email);
					if (c != null) {
						if (c.getClave().equals(password)) {
							request.getSession().setAttribute("cliente", c);
							request.getRequestDispatcher("/JSP/servicioscliente.jsp").forward(request, response);
						} else {
							response.sendRedirect(request.getContextPath() + "/JSP/login.jsp");
						}
					}
				} catch (Exception ex) {
					response.sendRedirect(request.getContextPath() + "/JSP/login.jsp");
				}
			}
			

			break;
		}
	}
}
