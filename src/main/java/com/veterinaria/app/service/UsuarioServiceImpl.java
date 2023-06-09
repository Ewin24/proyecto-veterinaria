package com.veterinaria.app.service;

import com.veterinaria.app.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioService.save(usuario);
    }

    @Override
    public Usuario FindOne(Long id) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuarioService.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findone(Long id) {
        return usuarioService.findone(id);
    }
}
