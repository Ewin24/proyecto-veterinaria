package com.veterinaria.app.service;


import com.veterinaria.app.entity.ConsultaVeterinaria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IConsultaService {
	
	public List<ConsultaVeterinaria> findAll();

	public void save(ConsultaVeterinaria club);

	public ConsultaVeterinaria FindOne(Long id);

	public void delete(Long id);

    @Transactional(readOnly = true)
    ConsultaVeterinaria findone(Long id);
}
