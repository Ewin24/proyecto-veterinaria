package repository;

import org.springframework.data.repository.CrudRepository;

import entity.Paciente;

public interface IPacienteRepository extends CrudRepository<Paciente, Long>{

}
