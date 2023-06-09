package com.veterinaria.app.service;

import com.veterinaria.app.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUsuarioService {

	public List<Usuario> findAll();

	public void save(Usuario club);

	public Usuario FindOne(Long id);

	public void delete(Long id);

    @Transactional(readOnly = true)
    Usuario findone(Long id);
}
