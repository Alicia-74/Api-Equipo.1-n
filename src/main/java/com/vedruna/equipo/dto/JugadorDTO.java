package com.vedruna.equipo.dto;

import com.vedruna.equipo.persistance.models.Jugador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JugadorDTO {
    
    private Long jugadorId;
    private String name;
    private int edad;
    private String nombreEquipo;

    public JugadorDTO (Jugador j){
        this.jugadorId = j.getJugadorId();
        this.name = j.getName();
        this.edad = j.getEdad();
        this.nombreEquipo = j.getUserEquipo().getName();
    }
   
}
