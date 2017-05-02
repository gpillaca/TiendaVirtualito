package dao.interfaces;

import java.util.ArrayList;

import beans.PedidoBean;
import beans.ProductoBean;

public interface PedidoDAO {
	public int registrarPedido(PedidoBean pedido) throws Exception;
	public int registarDetallePedido(int pedido_id, ArrayList<ProductoBean> productos) throws Exception;
	public int obtenerIdUltimoPedido() throws Exception;
}
