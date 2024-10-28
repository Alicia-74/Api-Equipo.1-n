package com.vedruna.equipo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.equipo.dto.JugadorDTO;
import com.vedruna.equipo.services.JugadorServiceI;

@RestController
@RequestMapping("/api/v1/jugadores")
public class JugadorController {

    @Autowired
    private JugadorServiceI jugadorMngmnt;

    // 3. Consultar todos los jugadores (Debe verse solo el nombre del equipo)
    @GetMapping
    public List<JugadorDTO> getAllJugadores() {
        return jugadorMngmnt.showAllJugadores();
    }

    // 4. Crear nuevo jugador
    @PostMapping("/insert")
    public void insertJugador(@RequestBody JugadorDTO jugador) {
        jugadorMngmnt.insertJugador(jugador);
    }

    // 6. Inscribir a un jugador en un equipo
    @PutMapping("/{jugadorId}/equipo/{equipoId}")
    public JugadorDTO asignarJugadorAEquipo(@PathVariable Long jugadorId, @PathVariable Long equipoId) {
        return jugadorMngmnt.asignarJugadorAEquipo(jugadorId, equipoId);
    }

    // 8. Borrar jugador (No debe borrarse su equipo)
    @DeleteMapping("delete/{id}")
    public String deleteJugador(@PathVariable Long id) {
        jugadorMngmnt.deleteJugador(id);
        return "Jugador Eliminado";
    }
}