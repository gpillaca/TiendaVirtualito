package dao.interfaces;

import java.util.ArrayList;

import beans.CategoriaBean;

public interface CategoriaDAO {
	
	public ArrayList<CategoriaBean> listarCategorias() throws Exception;
	public int agregarCategoria(CategoriaBean categoria) throws Exception;
	public int editarCategoria(CategoriaBean categoria) throws Exception;
	public int eliminarCategoria(int id) throws Exception;

}
