package com.vedruna.equipo.services;

import java.util.List;

import com.vedruna.equipo.dto.EquipoDTO;
import com.vedruna.equipo.persistance.models.Equipo;

public interface EquipoServiceI {

    List<EquipoDTO> showAllEquipo();
    EquipoDTO getEquipoByName(String name);
    void insertEquipo(EquipoDTO equipo);
    void updateEquipo(Long id, EquipoDTO equipo);
    void deleteEquipo(Long id);
    Equipo getEquipoById(Long id);
    EquipoDTO asignarJugadorAEquipo(Long equipoId, Long jugadorId);
    List<EquipoDTO> findAll();
    EquipoDTO findById(Long id);
}
