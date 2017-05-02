package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CategoriaBean;
import beans.ProductoBean;
import dao.interfaces.CategoriaDAO;
import dao.interfaces.ProductoDAO;
import daofactory.DAOFactory;

/**
 * Servlet implementation class Carrito
 */
@WebServlet("/Carrito")
public class Carrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<CategoriaBean> categorias = null;
		
		HttpSession sesion = request.getSession();
		ArrayList<ProductoBean> productos = null;
		ArrayList<String> productosCarrito = null;
		
		try {
			DAOFactory daoFactory = DAOFactory.getFAOFactory(DAOFactory.MYSQL);
			CategoriaDAO categoriaDAO = daoFactory.getCategoriaDAO();
			categorias = categoriaDAO.listarCategorias();
		} catch (Exception e) {
			e.getMessage();
		}
		
		try {
			
			DAOFactory daoFactory = DAOFactory.getFAOFactory(DAOFactory.MYSQL);
			ProductoDAO productoDAO = daoFactory.getProductoDAO();
			
			if (sesion.getAttribute("productos") == null) {
				response.sendRedirect("Producto");
			} else {
				productosCarrito = (ArrayList<String>) sesion.getAttribute("productos");
				
				if (productosCarrito.size() > 0) {
					productos = new ArrayList<ProductoBean>();
					for(int i = 0; i< productosCarrito.size(); i++){
						
						productos.add(productoDAO.buscaProductoxId(Integer.parseInt(productosCarrito.get(i))));
					}
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/carrito.jsp");
					request.setAttribute("productos", productos);
					request.setAttribute("categorias", categorias);
					rd.forward(request, response);
				} else {
					response.sendRedirect("Producto");
				}
				
			}
			
			
		} catch (Exception e) {
			e.getMessage();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
