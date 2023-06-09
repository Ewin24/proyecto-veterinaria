package com.veterinaria.app.repository;

import com.veterinaria.app.entity.ConsultaVeterinaria;
import org.springframework.data.repository.CrudRepository;
public interface IConsultaRepository extends CrudRepository<ConsultaVeterinaria, Long> {
}
