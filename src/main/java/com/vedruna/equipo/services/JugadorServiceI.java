package com.vedruna.equipo.services;

import java.util.List;

import com.vedruna.equipo.dto.JugadorDTO;
import com.vedruna.equipo.persistance.models.Jugador;

public interface JugadorServiceI {

    List<JugadorDTO> showAllJugadores();
    List<JugadorDTO> getJugadorByName(String name);
    void insertJugador(JugadorDTO jugador);
    void updateJugador(Long id, JugadorDTO jugador);
    void deleteJugador(Long id);
    Jugador getJugadorById(Long id);
    JugadorDTO asignarJugadorAEquipo(Long jugadorId, Long equipoId);
}
