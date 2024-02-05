package com.seba.turnosbackend.repositories;


import com.seba.turnosbackend.entities.Turno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends CrudRepository<Turno, Long> {
}
