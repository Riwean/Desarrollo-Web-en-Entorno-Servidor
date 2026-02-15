package com.nasa.asteroides_peligrosos.repository;

import com.nasa.asteroides_peligrosos.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    // Obtener las últimas N consultas ordenadas por fecha de consulta descendente
    List<Consulta> findTop10ByOrderByFechaHoraConsultaDesc();

    // Obtener consultas de un usuario específico
    List<Consulta> findByUsuarioOrderByFechaHoraConsultaDesc(String usuario);
}
