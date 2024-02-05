package com.seba.turnosbackend.services;


import com.seba.turnosbackend.entities.Paciente;

import java.util.Optional;


public interface IPacienteService {

    public Paciente traerPorId(Long id);

    public void guardarPaciente(Paciente paciente);
    public void  eliminar(Long id);




}
