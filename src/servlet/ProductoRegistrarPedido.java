package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import beans.ClienteBean;
import beans.PedidoBean;
import beans.ProductoBean;
import dao.interfaces.PedidoDAO;
import dao.interfaces.ProductoDAO;
import daofactory.DAOFactory;

/**
 * Servlet implementation class ProductoComprar
 */
@WebServlet("/ProductoComprar")
public class ProductoRegistrarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoRegistrarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		ArrayList<String> productosCarrito = (ArrayList<String>) sesion.getAttribute("productos");
		ClienteBean cliente = (ClienteBean) sesion.getAttribute("usuario");
		
		ArrayList<ProductoBean> productos = new ArrayList<ProductoBean>();
		double subtotal = 0;
		int idPedido = 0;
		try {
			
			DAOFactory daoFactory = DAOFactory.getFAOFactory(DAOFactory.MYSQL);
			ProductoDAO productoDAO = daoFactory.getProductoDAO();
			PedidoDAO pedidoDAO = daoFactory.getPedidoDAO();
			
			
			for (int i = 0; i<productosCarrito.size(); i++) {
				subtotal+= productoDAO.buscaProductoxId(Integer.parseInt(productosCarrito.get(i))).getPrecio();
				productos.add(productoDAO.buscaProductoxId(Integer.parseInt(productosCarrito.get(i))));
			}
			
			double igv = subtotal*0.18;
			double montototal = igv + subtotal;
			PedidoBean pedidoBean = new PedidoBean();
			pedidoBean.setCliente_id(cliente.getId());
			pedidoBean.setMontototal(montototal);
			pedidoBean.setIgv(igv);
			pedidoBean.setSubtotal(subtotal);
			
			int status = pedidoDAO.registrarPedido(pedidoBean);
			
			if (status > 0) {
				idPedido = pedidoDAO.obtenerIdUltimoPedido();
				int statusDetalle = pedidoDAO.registarDetallePedido(idPedido, productos);
				if (statusDetalle > 0) {
					response.sendRedirect("Producto");
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
