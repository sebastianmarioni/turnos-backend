package com.seba.turnosbackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    private String email;

    @NotNull
    private String dni;

    @NotNull
    private String telefono;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="obra_social_id")
    private ObraSocial obraSocial;
}
