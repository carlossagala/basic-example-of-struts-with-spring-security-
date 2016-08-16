package DAO;

import models.Usuario;

public interface UsuarioDao {
	public Usuario getUser(String login) throws Exception;
}
