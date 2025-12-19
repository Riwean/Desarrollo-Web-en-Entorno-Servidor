package com.pruebas.bdd1.services;

import com.pruebas.bdd1.model.Actores;
import com.pruebas.bdd1.repository.ActoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActoresService {

    private final ActoresRepository actoresRepository;

    public ActoresService(ActoresRepository actoresRepository) {
        this.actoresRepository = actoresRepository;
    }

    public List<Actores> findAll() {
        return actoresRepository.findAll();
    }

    public Actores findById(Integer id) {
        return actoresRepository.findById(id).orElse(null);
    }

    public Actores save(Actores actor) {
        return actoresRepository.save(actor);
    }
}