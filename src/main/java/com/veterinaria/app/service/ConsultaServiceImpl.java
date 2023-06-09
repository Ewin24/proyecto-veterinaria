package com.veterinaria.app.service;

import com.veterinaria.app.entity.ConsultaVeterinaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConsultaServiceImpl implements IConsultaService {

    @Autowired
    private IConsultaService consultaVeterinariaService;

    @Override
    @Transactional(readOnly = true)
    public List<ConsultaVeterinaria> findAll() {
        return consultaVeterinariaService.findAll();
    }

    @Override
    @Transactional
    public void save(ConsultaVeterinaria consultaVeterinaria) {
        consultaVeterinariaService.save(consultaVeterinaria);
    }

    @Override
    public ConsultaVeterinaria FindOne(Long id) {
        return consultaVeterinariaService.FindOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        consultaVeterinariaService.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ConsultaVeterinaria findone(Long id) {
        return consultaVeterinariaService.findone(id);
    }
}
