package com.pruebas.bdd1.services;

import com.pruebas.bdd1.model.Episodios;
import com.pruebas.bdd1.repository.EpisodiosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodiosService {

    private final EpisodiosRepository episodiosRepository;

    public EpisodiosService(EpisodiosRepository episodiosRepository) {
        this.episodiosRepository = episodiosRepository;
    }

    public List<Episodios> findAll() {
        return episodiosRepository.findAll();
    }

    public Episodios findById(Integer id) {
        return episodiosRepository.findById(id).orElse(null);
    }

    public Episodios save(Episodios episodio) {
        return episodiosRepository.save(episodio);
    }
}
