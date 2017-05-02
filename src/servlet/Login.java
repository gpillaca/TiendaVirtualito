package servlet;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import beans.CategoriaBean;
import beans.ClienteBean;
import dao.interfaces.CategoriaDAO;
import dao.interfaces.ClienteDAO;
import daofactory.DAOFactory;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<CategoriaBean> categorias = null;
		
		
		try {
			HttpSession sesion = request.getSession();
			sesion.removeAttribute("usuario");
			sesion.removeAttribute("productos");
			
			DAOFactory daoFactory = DAOFactory.getFAOFactory(DAOFactory.MYSQL);
			CategoriaDAO categoriaDAO = daoFactory.getCategoriaDAO();
			categorias = categoriaDAO.listarCategorias();
		} catch (Exception e) {
			e.getMessage();
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
		request.setAttribute("categorias", categorias);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		HttpSession sesion = null;
		
		try {
			DAOFactory daoFactory = DAOFactory.getFAOFactory(DAOFactory.MYSQL);
			ClienteDAO clienteDAO = daoFactory.getClienteDAO();
			ClienteBean cliente = clienteDAO.validarCLiente(usuario, clave);
			
			if (cliente == null) {
				response.sendRedirect("Login");
			} else {
				sesion = request.getSession();
				sesion.setAttribute("usuario", cliente);
				response.sendRedirect("Producto");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		
	}

}
