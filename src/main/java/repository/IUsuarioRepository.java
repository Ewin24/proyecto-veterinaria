package repository;

import org.springframework.data.repository.CrudRepository;

import entity.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long>{

}
