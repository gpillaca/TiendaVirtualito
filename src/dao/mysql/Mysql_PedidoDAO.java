package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import beans.PedidoBean;
import beans.ProductoBean;
import dao.interfaces.PedidoDAO;
import daofactory.MysqlDAOFactory;

public class Mysql_PedidoDAO implements PedidoDAO{

	@Override
	public int registrarPedido(PedidoBean pedido) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		int status = 0;
		
		Calendar calendar = new GregorianCalendar();
		String fecha = calendar.YEAR + "-" + calendar.MONTH + "-" + calendar.DATE;
		
		try {
			con = MysqlDAOFactory.getConexion();
			stmt = con.createStatement();
			String sql = "INSERT INTO pedidos (cliente_id, fecha, montototal, igv, subtotal) "+
						" VALUES ( "+pedido.getId()+", "+ fecha +", "+pedido.getMontototal()+", "+
						pedido.getIgv()+", "+pedido.getSubtotal()+");";
			
			status = stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (stmt != null) stmt.close();
			if (con != null) con.close();
		}
		
		return status;
	}

	@Override
	public int registarDetallePedido(int pedido_id, ArrayList<ProductoBean> producto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int obtenerIdUltimoPedido() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int idPedido = 0;
		
		try {
			con = MysqlDAOFactory.getConexion();
			stmt = con.createStatement();
			String sql = "SELECT max(id) as id FROM pedidos";
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				idPedido = rs.getInt("id");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (con != null) con.close();
		}
		
		return idPedido;
	}

}
