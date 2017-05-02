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
 * Servlet implementation class CategoriaBuscar
 */
@WebServlet("/CategoriaBuscar")
public class CategoriaBuscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaBuscar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idCategoria = 0;
		ArrayList<ProductoBean> productos = null;
		if (request.getParameter("id") != null) {
			
			try {
				idCategoria = Integer.parseInt(request.getParameter("id"));
				
				DAOFactory daoFactory = DAOFactory.getFAOFactory(DAOFactory.MYSQL);
				ProductoDAO productoDAO = daoFactory.getProductoDAO();
				productos = productoDAO.buscarProductoxCategoria(idCategoria);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/CategoriaListar");
		request.setAttribute("productos", productos);
		rd.include(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
