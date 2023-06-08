package repository;

import org.springframework.data.repository.CrudRepository;

import entity.ConsultaVeterinaria;

public interface IConsultaRepository extends CrudRepository<ConsultaVeterinaria, Long>{
	
}
