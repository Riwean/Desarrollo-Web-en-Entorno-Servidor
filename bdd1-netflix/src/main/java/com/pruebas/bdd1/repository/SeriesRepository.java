package com.pruebas.bdd1.repository;

import com.pruebas.bdd1.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Integer> {
    // De momento no hace falta añadir nada más.
    // JpaRepository ya trae findAll, findById, save, deleteById, etc.
}
