package com.vedruna.equipo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.equipo.dto.EquipoDTO;
import com.vedruna.equipo.dto.JugadorDTO;
import com.vedruna.equipo.persistance.models.Equipo;
import com.vedruna.equipo.persistance.models.Jugador;
import com.vedruna.equipo.persistance.repository.JugadorRepositoryI;

@Service
public class JugadorServiceImpl implements JugadorServiceI {

    @Autowired
    JugadorRepositoryI jugadorRepo;
    
    @Autowired
    EquipoServiceI equipoRepo;

    @Override
    public List<JugadorDTO> showAllJugadores() {
        List<Jugador> jugadoresList = jugadorRepo.findAll();
        List<JugadorDTO> jugadoresDTOList = new ArrayList<>();

        for (Jugador jugador : jugadoresList) {
            jugadoresDTOList.add(new JugadorDTO(jugador));
        }

        return jugadoresDTOList;
    }

    @Override
    public List<JugadorDTO> getJugadorByName(String name) {
        List<Jugador> jugadoresList = jugadorRepo.findByName(name);
        List<JugadorDTO> jugadoresDTOList = new ArrayList<>();

        for (Jugador jugador : jugadoresList) {
            jugadoresDTOList.add(new JugadorDTO(jugador));
        }

        return jugadoresDTOList;
    }

    public Jugador getJugadorById(Long id) {
        return jugadorRepo.findById(id).get(); 
    }

    @Override
    public void insertJugador(JugadorDTO j) {
        // Crear jugador a partir del DTO
        Jugador newJugador = new Jugador();
        newJugador.setJugadorId(j.getJugadorId());
        newJugador.setName(j.getName());
        newJugador.setEdad(j.getEdad());
         // Asignar el ID del equipo si existe en el DTO
        if (j.getNombreEquipo() != null) { // Aquí se verifica el nombre del equipo
            Equipo equipo = new Equipo();
            equipo.setName(j.getNombreEquipo()); // Asignar el nombre del equipo, si es necesario
            newJugador.setUserEquipo(equipo); // Establecer la referencia al equipo
        }
        // Guardar jugador
        jugadorRepo.save(newJugador);
    }

    @Override
    public void updateJugador(Long id, JugadorDTO jugador) {
        // Actualizar información del jugador
        jugador.setJugadorId(id);
        jugadorRepo.save(jugador);
    }

    @Override
    public void deleteJugador(Long id) {
        jugadorRepo.deleteById(id);
    }

    @Override
    public JugadorDTO asignarJugadorAEquipo(Long jugadorId, Long equipoId) {
        // Obtener el jugador y el equipo por sus ID
        Jugador jugador = jugadorRepo.findById(jugadorId).get(); // Obtiene el jugador
        Equipo equipo = equipoRepo.findById(equipoId).get(); // Obtiene el equipo

        // Asigna el equipo al jugador
        jugador.setUserEquipo(equipo);
        
        // Guarda los cambios
        jugadorRepo.save(jugador);

        // Retorna el DTO del jugador actualizado
        return new JugadorDTO(jugador);
    }


}
