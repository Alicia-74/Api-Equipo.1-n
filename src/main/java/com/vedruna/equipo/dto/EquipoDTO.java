package com.vedruna.equipo.dto;

import java.util.ArrayList;
import java.util.List;

import com.vedruna.equipo.persistance.models.Equipo;
import com.vedruna.equipo.persistance.models.Jugador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipoDTO {

    private Long equipoId;
    private String name;
    private List<JugadorDTO> jugadores;

    public EquipoDTO(Equipo e){
        this.equipoId = e.getEquipoId();
        this.name = e.getName();
        this.jugadores = convertirJugadoresAJugadorDTOs(e.getJugadores());
    }

    // Método para convertir la lista de Jugadores a JugadorDTOs
    private List<JugadorDTO> convertirJugadoresAJugadorDTOs(List<Jugador> jugadores) {
        List<JugadorDTO> jugadoresDTO = new ArrayList<>();
        if (jugadores != null) {
            for (Jugador jugador : jugadores) {
                jugadoresDTO.add(new JugadorDTO(jugador)); // Asumiendo que JugadorDTO tiene un constructor que acepta Jugador
            }
        }
        return jugadoresDTO;
    }

    public Equipo get() {
        Equipo equipo = new Equipo();
        equipo.setEquipoId(this.equipoId);
        equipo.setName(this.name);
        // No se asignan jugadores aquí, pero podrías agregar lógica si es necesario
        return equipo;
    }

}
