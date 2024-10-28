package com.vedruna.equipo.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.equipo.dto.EquipoDTO;
import com.vedruna.equipo.persistance.models.Equipo;

@Repository
public interface EquipoRepositoryI extends JpaRepository<Equipo, Long>{
    
    Equipo findByName(String name);
    void save(EquipoDTO equipo);

}




