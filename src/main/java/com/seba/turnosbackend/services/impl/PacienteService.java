package com.seba.turnosbackend.services.impl;


import com.seba.turnosbackend.entities.Paciente;
import com.seba.turnosbackend.exceptions.PacienteNotFoundException;
import com.seba.turnosbackend.repositories.IPacienteRepository;
import com.seba.turnosbackend.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;


    @Override
    public Paciente traerPorId(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException("Paciente no encontrado con ID: " + id));
    }

    @Override
    public void guardarPaciente(Paciente paciente) {
        this.pacienteRepository.save(paciente);

    }

    @Override
    public void eliminar(Long id) {
        this.pacienteRepository.deleteById(id);
    }
}
