package com.pruebas.bdd1.repository;

import com.pruebas.bdd1.model.Episodios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodiosRepository extends JpaRepository<Episodios, Integer> {
}
