package com.seba.turnosbackend.services.impl;

import com.seba.turnosbackend.entities.FormaPago;
import com.seba.turnosbackend.repositories.IFormaPagoRepository;
import com.seba.turnosbackend.repositories.IPacienteRepository;
import com.seba.turnosbackend.services.IFormaPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FormaPagoService implements IFormaPagoService {

    @Autowired
    private IFormaPagoRepository formaPagoRepository;

    @Override
    public FormaPago traerPorId(Long id) {
        return formaPagoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("La FormaPago no existe con el ID: " + id));
    }
}
