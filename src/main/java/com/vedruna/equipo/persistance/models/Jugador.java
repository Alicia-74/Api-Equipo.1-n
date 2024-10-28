package com.vedruna.equipo.persistance.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
@Table(name="jugadores")
public class Jugador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idjugador")
    private Long jugadorId;

    @Column(name="nombre")
    private String name;

    @Column(name="edad")
    private int edad;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="equipos_idequipo", referencedColumnName = "idequipo")
    private Equipo userEquipo;
}
