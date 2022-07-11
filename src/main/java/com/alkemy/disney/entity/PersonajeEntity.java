package com.alkemy.disney.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="personaje")
@Data
//@SQLDelete(sql="UPDATE personaje SET deleted = true WHERE id=?")
//@Where(clause="deleted=false")
public class PersonajeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String nombre;
    private int edad;
    private double peso;
    private String historia;
    private boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy="personajes", cascade=CascadeType.ALL)
    private List<PeliculaEntity> peliculas = new ArrayList<>();

    public void addPelicula(PeliculaEntity pelicula){this.peliculas.add(pelicula);}
    public void removePelicula(PeliculaEntity pelicula){this.peliculas.remove(pelicula);}
}
