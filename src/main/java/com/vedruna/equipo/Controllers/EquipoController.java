package com.vedruna.equipo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.equipo.dto.EquipoDTO;
import com.vedruna.equipo.services.EquipoServiceI;

@RestController
@RequestMapping("/api/v1/equipo")
public class EquipoController {

    @Autowired
    private EquipoServiceI equipoMngmnt;

    // 1. Consultar todos los equipos (Deben verse sus jugadores)
    @GetMapping
    public List<EquipoDTO> getAllEquipos() {
        return equipoMngmnt.showAllEquipo();
    }

    // 2. Consultar un solo equipo (Deben verse sus jugadores)
    @GetMapping("/{id}")
    public EquipoDTO getEquipoById(@PathVariable Long id) {
        return equipoMngmnt.findById(id);
    }

    // 5. Crear nuevo equipo
    @PostMapping("/insert")
    public void insertEquipo(@RequestBody EquipoDTO equipo) {
        equipoMngmnt.insertEquipo(equipo);
    }


    // 7. Borrar equipo (No deben borrarse sus jugadores)
    @DeleteMapping("delete/{id}")
    public String deleteEquipo(@PathVariable Long id) {
        equipoMngmnt.deleteEquipo(id);
        return "Equipo Eliminado";
    }
}
