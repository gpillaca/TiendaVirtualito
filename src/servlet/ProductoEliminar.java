package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductoEliminar
 */
@WebServlet("/ProductoEliminar")
public class ProductoEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoEliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pos = Integer.parseInt(request.getParameter("pos"));
		HttpSession sesion = request.getSession();
		ArrayList<String> productosCarrito = (ArrayList<String>) sesion.getAttribute("productos");
		
		productosCarrito.remove(pos);
		
		if (productosCarrito.size() > 0) {
			sesion.setAttribute("productos", productosCarrito);
			
			response.sendRedirect("Carrito");
		} else {
			response.sendRedirect("Producto");
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
