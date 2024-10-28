package com.vedruna.equipo.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.equipo.dto.JugadorDTO;
import com.vedruna.equipo.persistance.models.Jugador;

@Repository
public interface JugadorRepositoryI extends JpaRepository<Jugador, Long>{
    
    List<Jugador> findByName(String name);
    void save(JugadorDTO jugador);

}
