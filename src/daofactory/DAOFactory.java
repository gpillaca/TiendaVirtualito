package daofactory;

import dao.interfaces.AdministradorDAO;
import dao.interfaces.CategoriaDAO;
import dao.interfaces.ClienteDAO;
import dao.interfaces.ProductoDAO;

public abstract class DAOFactory {
	
	public static final int MYSQL = 1;
	
	public abstract ProductoDAO getProductoDAO();
	public abstract ClienteDAO getClienteDAO();
	public abstract CategoriaDAO getCategoriaDAO();
	public abstract AdministradorDAO getAdministracorDAO();
	
	public static DAOFactory getFAOFactory(int factory){
		switch (factory) {
		case MYSQL:
			return new MysqlDAOFactory();

		default:
			return null;
		}
	}

}
