package com.veterinaria.app.service;

import com.veterinaria.app.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteService pacienteService;

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> findAll() {
        return pacienteService.findAll();
    }

    @Override
    @Transactional
    public void save(Paciente paciente) {
        pacienteService.save(paciente);
    }

    @Override
    public Paciente FindOne(Long id) {
        return pacienteService.FindOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pacienteService.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente findone(Long id) {
        return pacienteService.findone(id);
    }
}
