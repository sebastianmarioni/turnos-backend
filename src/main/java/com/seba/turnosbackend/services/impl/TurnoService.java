package com.seba.turnosbackend.services.impl;

import com.seba.turnosbackend.entities.FormaPago;
import com.seba.turnosbackend.entities.Paciente;
import com.seba.turnosbackend.entities.Turno;
import com.seba.turnosbackend.repositories.IFormaPagoRepository;
import com.seba.turnosbackend.repositories.IPacienteRepository;
import com.seba.turnosbackend.repositories.ITurnoRepository;
import com.seba.turnosbackend.services.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private IFormaPagoRepository formaPagoRepository;

    public List<Turno> getAllTurnos() {
        return (List<Turno>) turnoRepository.findAll();
    }

    public Optional<Turno> getTurnoById(Long id) {
        return turnoRepository.findById(id);
    }

    public Turno saveTurno(Turno turno) {
        // Puedes realizar validaciones adicionales aquí antes de guardar

        /*
        Paciente paciente = turno.getPaciente();
        if (paciente != null && paciente.getId() == null) {
            // El paciente aún no ha sido persistido, por lo que lo persistimos primero
            paciente = pacienteRepository.save(paciente);
            turno.setPaciente(paciente);
        }

        FormaPago formaPago = turno.getFormaPago();
        if (formaPago != null && formaPago.getId() == null) {
            formaPago = formaPagoRepository.save(formaPago);
            turno.setFormaPago(formaPago);
        }

    */

        return turnoRepository.save(turno);
    }

    public boolean existsById(Long id) {
        return turnoRepository.existsById(id);
    }

    public Turno updateTurno(Long id, Turno turno) {
        if (!turnoRepository.existsById(id)) {
            // Puedes lanzar una excepción o manejar de otra manera el caso en el que el turno no exista
            return null;
        }
        // Actualizar los campos del turno existente con los datos proporcionados
        Turno turnoExistente = turnoRepository.findById(id).orElse(null);
        if (turnoExistente != null) {
            // Actualizar los campos que necesitas
            turnoExistente.setFecha(turno.getFecha());
            turnoExistente.setHora(turno.getHora());
            // Actualizar más campos si es necesario
            // ...
            return turnoRepository.save(turnoExistente);
        }
        return null;
    }

    public void deleteTurno(Long id) {
        turnoRepository.deleteById(id);
    }
}
