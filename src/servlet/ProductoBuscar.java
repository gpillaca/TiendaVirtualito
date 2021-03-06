package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ProductoBean;
import dao.interfaces.ProductoDAO;
import daofactory.DAOFactory;

/**
 * Servlet implementation class ProductoBuscar
 */
@WebServlet("/ProductoBuscar")
public class ProductoBuscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoBuscar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		System.out.println("nombre " +nombre);	
			
			ArrayList<ProductoBean> productos = null;
			try {
				DAOFactory daoFactory = DAOFactory.getFAOFactory(DAOFactory.MYSQL);
				ProductoDAO productoDAO = daoFactory.getProductoDAO();
				productos = productoDAO.buscaProductoxNombre(nombre);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/CategoriaListar");
			request.setAttribute("productos", productos);
			rd.include(request, response);
		
	}

}
