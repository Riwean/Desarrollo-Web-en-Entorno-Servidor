package com.pruebas.bdd1.services;

import com.pruebas.bdd1.model.Series;
import com.pruebas.bdd1.repository.SeriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService {

    private final SeriesRepository seriesRepository;

    public SeriesService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    public List<Series> findAll() {
        return seriesRepository.findAll();
    }

    public Series findById(Integer id) {
        return seriesRepository.findById(id).orElse(null);
    }

    public Series save(Series serie) {
        return seriesRepository.save(serie);
    }
}
