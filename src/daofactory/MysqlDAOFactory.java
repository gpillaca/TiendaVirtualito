package daofactory;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.interfaces.AdministradorDAO;
import dao.interfaces.CategoriaDAO;
import dao.interfaces.ClienteDAO;
import dao.interfaces.PedidoDAO;
import dao.interfaces.ProductoDAO;
import dao.mysql.Mysql_AdministradorDAO;
import dao.mysql.Mysql_CategoriaDAO;
import dao.mysql.Mysql_ClienteDAO;
import dao.mysql.Mysql_PedidoDAO;
import dao.mysql.Mysql_ProductoDAO;

public class MysqlDAOFactory extends DAOFactory{

	
	public static Connection getConexion(){
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/tiendavirtual";
		String user = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.getMessage();
		}
		
		return con;
	}
	
	@Override
	public ProductoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		return new Mysql_ProductoDAO();
	}
	

	@Override
	public ClienteDAO getClienteDAO() {
		// TODO Auto-generated method stub
		return new Mysql_ClienteDAO();
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return new Mysql_CategoriaDAO();
	}

	@Override
	public AdministradorDAO getAdministracorDAO() {
		// TODO Auto-generated method stub
		return new Mysql_AdministradorDAO();
	}

	@Override
	public PedidoDAO getPedidoDAO() {
		// TODO Auto-generated method stub
		return new Mysql_PedidoDAO();
	}

}
