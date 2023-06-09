package com.veterinaria.app.service;


import com.veterinaria.app.entity.Paciente;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IPacienteService {
	
	public List<Paciente> findAll();

	public void save(Paciente club);

	public Paciente FindOne(Long id);

	public void delete(Long id);


    @Transactional(readOnly = true)
    Paciente findone(Long id);
}
