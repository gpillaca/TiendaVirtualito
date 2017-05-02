package dao.interfaces;

import java.util.ArrayList;

import beans.ClienteBean;

public interface ClienteDAO {
	public ClienteBean validarCLiente(String usuario, String clave) throws Exception;
	public ArrayList<ClienteBean> listarClientes() throws Exception;
	public int agregarCliente(ClienteBean cliente) throws Exception;
	public int editarCliente(ClienteBean cliente) throws Exception;
	public int eliminarCliente(int id) throws Exception;
}
