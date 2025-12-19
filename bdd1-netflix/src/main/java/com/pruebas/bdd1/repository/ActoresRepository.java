package com.pruebas.bdd1.repository;

import com.pruebas.bdd1.model.Actores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActoresRepository extends JpaRepository<Actores, Integer> {
}
