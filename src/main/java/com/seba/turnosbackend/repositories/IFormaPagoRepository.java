package com.seba.turnosbackend.repositories;

import com.seba.turnosbackend.entities.FormaPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormaPagoRepository extends JpaRepository<FormaPago,Long> {
}
