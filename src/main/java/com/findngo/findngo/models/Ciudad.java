package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ciudad")
public class Ciudad {
    @Id
    @Getter @Setter @Column(name = "ID_CIUDAD", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "NOMBRE", nullable = false)
    private String nombre;

}