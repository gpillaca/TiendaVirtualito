package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.CategoriaBean;
import beans.ProductoBean;
import dao.interfaces.ProductoDAO;
import daofactory.MysqlDAOFactory;

public class Mysql_ProductoDAO implements ProductoDAO{

	@Override
	public ArrayList<ProductoBean> listarProductos() throws Exception {
		
		ArrayList<ProductoBean> productos = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = MysqlDAOFactory.getConexion();
			stmt = con.createStatement();
			String sql = " select p.id, p.nombre, p.precio, p.descripcion, p.categoria_id, c.nombre as categoria, p.imagen "+
						" from categorias c, productos p where p.categoria_id = c.id";
			rs = stmt.executeQuery(sql);
			
			productos = new ArrayList<ProductoBean>();
			
			while (rs.next()) {
			
				ProductoBean productoBean = new ProductoBean();

				productoBean.setId(rs.getInt("id"));
				productoBean.setNombre(rs.getString("nombre"));
				productoBean.setPrecio(rs.getDouble("precio"));
				productoBean.setDescripcion(rs.getString("descripcion"));
				productoBean.setCategoria_id(rs.getInt("categoria_id"));
				productoBean.setCategoria(rs.getString("categoria"));
				productoBean.setUrl(rs.getString("imagen"));
				
				productos.add(productoBean);
			}
			
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
	
		return productos;
	}

	@Override
	public int agregarProducto(ProductoBean producto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editarProducto(ProductoBean producto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarProducto(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ProductoBean> buscarProductoxCategoria(int idCategoria) throws Exception {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<ProductoBean> productos = null;
		
		try {
			
			con = MysqlDAOFactory.getConexion();
			stmt = con.createStatement();
			String sql = "select p.id, p.nombre, p.precio, p.descripcion, p.categoria_id, c.nombre as categoria, p.imagen "+
						" from categorias c, productos p where p.categoria_id = c.id and p.categoria_id = " + idCategoria;
			rs = stmt.executeQuery(sql);
			
			productos = new ArrayList<ProductoBean>();
			
			while (rs.next()) {
				ProductoBean productoBean = new ProductoBean();
				productoBean.setId(rs.getInt("id"));
				productoBean.setNombre(rs.getString("nombre"));
				productoBean.setPrecio(rs.getDouble("precio"));
				productoBean.setDescripcion(rs.getString("descripcion"));
				productoBean.setCategoria_id(rs.getInt("categoria_id"));
				productoBean.setCategoria(rs.getString("categoria"));
				productoBean.setUrl(rs.getString("imagen"));
				
				productos.add(productoBean);
				
			}
			
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (con != null) con.close();
		}
		
		
		return productos;
	}

	@Override
	public ArrayList<ProductoBean> buscaProductoxNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<ProductoBean> productos = null;
		
		try {
			
			con = MysqlDAOFactory.getConexion();
			stmt = con.createStatement();
			String sql = "select p.id, p.nombre, p.precio, p.descripcion, p.categoria_id, c.nombre as categoria, p.imagen "+
						" from categorias c, productos p where p.categoria_id = c.id and p.nombre like '%" + nombre +"%'";
			rs = stmt.executeQuery(sql);
			
			productos = new ArrayList<ProductoBean>();
			
			while (rs.next()) {
				ProductoBean productoBean = new ProductoBean();
				productoBean.setId(rs.getInt("id"));
				productoBean.setNombre(rs.getString("nombre"));
				productoBean.setPrecio(rs.getDouble("precio"));
				productoBean.setDescripcion(rs.getString("descripcion"));
				productoBean.setCategoria_id(rs.getInt("categoria_id"));
				productoBean.setCategoria(rs.getString("categoria"));
				productoBean.setUrl(rs.getString("imagen"));
				
				productos.add(productoBean);
				
			}
			
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (con != null) con.close();
		}
		
		
		return productos;
	}

	@Override
	public ProductoBean buscaProductoxId(int id) throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ProductoBean productoBean = null;
		
		try {
			
			con = MysqlDAOFactory.getConexion();
			stmt = con.createStatement();
			String sql = "select p.id, p.nombre, p.precio, p.descripcion, p.categoria_id, c.nombre as categoria, p.imagen "+
						" from categorias c, productos p where p.categoria_id = c.id and p.id = " + id;
			rs = stmt.executeQuery(sql);
			
			
			while (rs.next()) {
				productoBean = new ProductoBean();
				productoBean.setId(rs.getInt("id"));
				productoBean.setNombre(rs.getString("nombre"));
				productoBean.setPrecio(rs.getDouble("precio"));
				productoBean.setDescripcion(rs.getString("descripcion"));
				productoBean.setCategoria_id(rs.getInt("categoria_id"));
				productoBean.setCategoria(rs.getString("categoria"));
				productoBean.setUrl(rs.getString("imagen"));
				
				
			}
			
		} catch (Exception e) {
			e.getMessage();
			System.out.println("ERRO: MYSQL_PROCUTODAO");
		} finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (con != null) con.close();
		}
		
		
		return productoBean;
	}

}
