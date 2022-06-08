package com.alkemy.disney.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "genero")
@Data
public class GeneroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String denominacion;
}
