package service;

import java.util.List;

import entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();

	public void save(Usuario club);

	public Usuario FindOne(Long id);

	public void delete(Long id);
	
}
