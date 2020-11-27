package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TiendaDao;
import dto.Tienda;

/**
 * Servlet implementation class TiendaController
 */
@WebServlet("/TiendaController")
public class TiendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TiendaController() {
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
		TiendaDao tDao = new TiendaDao();
		Tienda t = new Tienda();
		String accion = request.getParameter("accion");
		System.out.println(accion + "AAAAAAAAAAAAAAAAAAAA");
		switch (accion) {
		case "registro":
			String nombre = request.getParameter("nombre");
			String lema = request.getParameter("lema");
			String descripcion = request.getParameter("descripcion");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String propietario = request.getParameter("propietario");
			String facebook = request.getParameter("facebook");
			String web = request.getParameter("web");
			String imagen = request.getParameter("imagen");

			t.setNombre(nombre);
			t.setLema(lema);
			t.setDescripcion(descripcion);
			t.setClave(password);
			t.setEmail(email);
			t.setPropietario(propietario);
			t.setFacebook(facebook);
			t.setWeb(web);
			t.setImagen(imagen);

			try {
				if (tDao.findByEmail(email) != null) {
					System.out.println("YA EXISTE");
					PrintWriter pw = response.getWriter();
					pw.println("<script type=\"text/javascript\">");
					pw.println("alert('Ya existe tienda con ese email');");
					pw.println("</script>");
					request.getSession().setAttribute("error", "Ese email ya se encuentra registrado");
					request.getRequestDispatcher("/ERROR/errrorInsertarTienda.jsp").forward(request, response);
				} else {
					tDao.insert(t);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} catch (Exception e) {
				request.getSession().setAttribute("error", e.getMessage());
				request.getRequestDispatcher("/JSP/ERROR/errrorInsertarTienda.jsp").forward(request, response);
			}

			break;
		}
	}

}
