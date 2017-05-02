package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.CategoriaBean;
import beans.ProductoBean;
import dao.interfaces.CategoriaDAO;
import daofactory.MysqlDAOFactory;

public class Mysql_CategoriaDAO implements CategoriaDAO{

	@Override
	public ArrayList<CategoriaBean> listarCategorias() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<CategoriaBean> categorias = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = MysqlDAOFactory.getConexion();
			stmt = con.createStatement();
			String sql = "select * from categorias";
			rs = stmt.executeQuery(sql);
			
			categorias = new ArrayList<CategoriaBean>();
			
			while (rs.next()) {
			
				CategoriaBean categoriaBean = new CategoriaBean();

				categoriaBean.setId(rs.getInt("id"));
				categoriaBean.setNombre(rs.getString("nombre"));
				
				categorias.add(categoriaBean);
			}
			
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
	
		return categorias;
	}

	@Override
	public int agregarCategoria(CategoriaBean categoria) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editarCategoria(CategoriaBean categoria) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarCategoria(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
