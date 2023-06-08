package service;

import java.util.List;

import entity.Paciente;

public interface IPacienteService {
	
	public List<Paciente> findAll();

	public void save(Paciente club);

	public Paciente FindOne(Long id);

	public void delete(Long id);


}
