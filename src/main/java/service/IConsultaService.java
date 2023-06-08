package service;

import java.util.List;

import entity.ConsultaVeterinaria;

public interface IConsultaService {
	
	public List<ConsultaVeterinaria> findAll();

	public void save(ConsultaVeterinaria club);

	public ConsultaVeterinaria FindOne(Long id);

	public void delete(Long id);

}
