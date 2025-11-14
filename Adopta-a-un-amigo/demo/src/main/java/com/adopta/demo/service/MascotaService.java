package com.adopta.demo.service;

import com.adopta.demo.model.Mascota;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MascotaService {

    // Lista para almacenar mascotas
    private final List<Mascota> mascotas = new CopyOnWriteArrayList<>();
    private final AtomicLong nuevoId = new AtomicLong(1);

    // Guardar mascota y devuelve el id
    public Long guardar (Mascota mascota) {
        Long id = nuevoId.getAndIncrement();
        mascota.setId(id);
        mascotas.add(mascota);
        return id;
    }

    // Buscar mascota por ID
    public Mascota buscarPorId(Long id) {
        return mascotas.stream()
                .filter(m-> Objects.equals(m.getId(), id))
                .findFirst()
                .orElse(null);
    }

    // Listar todas las mascotas
    public List<Mascota> listarMascotas () {
        return List.copyOf(mascotas);
    }

    // Eliminar mascota por ID
    public boolean eliminar (Long id) {
        return mascotas.removeIf(m->Objects.equals(m.getId(), id));
    }

    // Actualizar mascota
    public boolean actualizar (Mascota actualizada) {
        for (int i = 0; i < mascotas.size(); i++) {
            if (Objects.equals(mascotas.get(i).getId(), actualizada.getId())) {
                mascotas.set(i, actualizada);
                return true;
            }
        }
        return false;
    }

    // Buscar por nombre (contiene)
    public List<Mascota> buscarPorNombre(String nombre) {
        return mascotas.stream()
                .filter(m -> m.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .toList();
    }

    // Filtrar por especie
    public List<Mascota> filtrarPorEspecie(String especie) {
        return mascotas.stream()
                .filter(m -> m.getEspecie().equalsIgnoreCase(especie))
                .toList();
    }

    // Buscar por nombre Y filtrar por especie
    public List<Mascota> buscarConFiltros(String nombre, String especie) {
        return mascotas.stream()
                .filter(m -> {
                    boolean coincideNombre = (nombre == null || nombre.isBlank()) ||
                            m.getNombre().toLowerCase().contains(nombre.toLowerCase());
                    boolean coincideEspecie = (especie == null || especie.isBlank()) ||
                            m.getEspecie().equalsIgnoreCase(especie);
                    return coincideNombre && coincideEspecie;
                })
                .toList();
    }
}
