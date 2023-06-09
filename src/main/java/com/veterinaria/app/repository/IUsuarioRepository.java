package com.veterinaria.app.repository;

import com.veterinaria.app.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long>{

}
