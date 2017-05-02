package dao.interfaces;

import java.util.ArrayList;

import beans.ProductoBean;

public interface ProductoDAO {
	
	public ArrayList<ProductoBean> listarProductos() throws Exception;
	public int agregarProducto(ProductoBean producto) throws Exception;
	public int editarProducto(ProductoBean producto) throws Exception;
	public int eliminarProducto(int id) throws Exception;
	public ArrayList<ProductoBean> buscarProductoxCategoria(int idCategoria) throws Exception;
	public ArrayList<ProductoBean> buscaProductoxNombre(String nombre) throws Exception;
	public ProductoBean buscaProductoxId(int id) throws Exception;
 
}
