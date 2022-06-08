package com.alkemy.disney.entity;


import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personaje")
@Data
@SQLDelete(sql = "UPDATE personaje SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PersonajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int edad;
    private double peso;
    private String historia;
    private String imagen;

    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
    private List<PeliSerieEntity> peliseries = new ArrayList<>();

    public void addPeliserie(PeliSerieEntity peliserie){this.peliseries.add(peliserie);}

    public void removePeliserie(PeliSerieEntity peliserie){this.peliseries.remove(peliserie);}
    }
