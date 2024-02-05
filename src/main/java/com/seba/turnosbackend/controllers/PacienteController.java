package com.seba.turnosbackend.controllers;


import com.seba.turnosbackend.entities.Paciente;
import com.seba.turnosbackend.exceptions.PacienteNotFoundException;
import com.seba.turnosbackend.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @GetMapping("/{id}")
    public Optional<Paciente> traerPorId(Long id) {
    return null;
    }
}
