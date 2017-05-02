package dao.interfaces;

import beans.AdministradorBean;

public interface AdministradorDAO {
	public AdministradorBean obtenerAdministrador(String usuario, String clave) throws Exception;

}
