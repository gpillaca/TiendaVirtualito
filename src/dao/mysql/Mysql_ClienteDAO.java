package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.ClienteBean;
import dao.interfaces.ClienteDAO;
import daofactory.MysqlDAOFactory;

public class Mysql_ClienteDAO implements ClienteDAO {

	@Override
	public ClienteBean validarCLiente(String usuario, String clave) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ClienteBean cliente = null;
		
		try {
			con = MysqlDAOFactory.getConexion();
			stmt = con.createStatement();
			String sql = "select * from clientes where usuario = '" + usuario + "' and clave ='" + clave + "'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				cliente = new ClienteBean();
				cliente.setId(rs.getInt("id"));
				cliente.setNombre(rs.getString("nombres"));
				cliente.setApellido(rs.getString("apellidos"));
				cliente.setSexo(rs.getInt("sexo"));
				cliente.setUsuario(rs.getString("usuario"));
				
			}
			
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (con != null) con.close();
		}
		
		return cliente;
	}

	@Override
	public ArrayList<ClienteBean> listarClientes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int agregarCliente(ClienteBean cliente) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editarCliente(ClienteBean cliente) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarCliente(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
