package com.seba.turnosbackend.controllers;


import com.seba.turnosbackend.entities.Turno;
import com.seba.turnosbackend.services.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/turnos")
public class TurnoController {

    private final ITurnoService turnoService;

    @Autowired
    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> getAllTurnos() {
        List<Turno> turnos = turnoService.getAllTurnos();
        return new ResponseEntity<>(turnos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> getTurnoById(@PathVariable Long id) {
        return turnoService.getTurnoById(id)
                .map(turno -> new ResponseEntity<>(turno, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Turno> createTurno(@RequestBody Turno turno) {
        Turno nuevoTurno = turnoService.saveTurno(turno);
        return new ResponseEntity<>(nuevoTurno, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turno> updateTurno(@PathVariable Long id, @RequestBody Turno turno) {
        if (!turnoService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Turno turnoActualizado = turnoService.updateTurno(id, turno);
        return new ResponseEntity<>(turnoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurno(@PathVariable Long id) {
        if (!turnoService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        turnoService.deleteTurno(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}