package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deporte")
public class Deporte {
    @Id
    @Getter @Setter @Column(name = "ID_DEPORTE", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "NOMBRE", nullable = false)
    private String nombre;

}