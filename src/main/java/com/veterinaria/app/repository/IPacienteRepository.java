package com.veterinaria.app.repository;

import com.veterinaria.app.entity.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface IPacienteRepository extends CrudRepository<Paciente, Long>{

}
