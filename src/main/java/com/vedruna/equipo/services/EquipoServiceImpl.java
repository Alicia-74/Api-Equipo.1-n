package com.vedruna.equipo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.equipo.dto.EquipoDTO;
import com.vedruna.equipo.persistance.models.Equipo;
import com.vedruna.equipo.persistance.models.Jugador;
import com.vedruna.equipo.persistance.repository.EquipoRepositoryI;
import com.vedruna.equipo.persistance.repository.JugadorRepositoryI;

@Service
public class EquipoServiceImpl implements EquipoServiceI {

    @Autowired
    private EquipoRepositoryI equipoRepo;

    @Autowired
    private JugadorRepositoryI jugadorRepo;

    @Override
    public List<EquipoDTO> showAllEquipo() {
        List<Equipo> equipos = equipoRepo.findAll();
        List<EquipoDTO> equipoDTOList = new ArrayList<>();
        
        for (Equipo equipo : equipos) {
            equipoDTOList.add(new EquipoDTO(equipo));
        }
        
        return equipoDTOList;
    }

    @Override
    public EquipoDTO getEquipoByName(String name) {
        Equipo equipo = equipoRepo.findByName(name);
        return new EquipoDTO(equipo);
    }

    @Override
    public void insertEquipo(EquipoDTO e) {
        Equipo newEquipo = new Equipo();
        newEquipo.setName(e.getName());
        equipoRepo.save(newEquipo);
    }

    @Override
    public void updateEquipo(Long id, EquipoDTO equipo) {
        equipo.setEquipoId(id);
        equipoRepo.save(equipo);
    }
     

    @Override
    public void deleteEquipo(Long id) {
        equipoRepo.deleteById(id);
    }

    @Override
    public Equipo getEquipoById(Long id) {
        return equipoRepo.findById(id).orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
    }

    @Override
    public EquipoDTO asignarJugadorAEquipo(Long equipoId, Long jugadorId) {
        Equipo equipo = equipoRepo.findById(equipoId).orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        Jugador jugador = jugadorRepo.findById(jugadorId).orElseThrow(() -> new RuntimeException("Jugador no encontrado"));

        jugador.setUserEquipo(equipo);
        jugadorRepo.save(jugador);

        return new EquipoDTO(equipo); // Devolver equipo actualizado
    }

    @Override
    public List<EquipoDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public EquipoDTO findById(Long id) {
        Equipo equipo = equipoRepo.findById(id).orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        return new EquipoDTO(equipo);
    }
}