package com.seba.turnosbackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate fecha;
    @NotNull
    private LocalTime hora;

    @ManyToOne(fetch =  FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne(fetch =  FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "forma_pago_id")
    private FormaPago formaPago;

}
