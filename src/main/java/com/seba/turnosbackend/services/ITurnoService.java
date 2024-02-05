package com.seba.turnosbackend.services;

import com.seba.turnosbackend.entities.Paciente;
import com.seba.turnosbackend.entities.Turno;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {
    public List<Turno> getAllTurnos() ;

    public Optional<Turno> getTurnoById(Long id);

    public Turno saveTurno(Turno turno) ;

    public boolean existsById(Long id);

    public Turno updateTurno(Long id, Turno turno);

    public void deleteTurno(Long id);
}
