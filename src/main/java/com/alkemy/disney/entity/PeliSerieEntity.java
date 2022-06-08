package com.alkemy.disney.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "peliserie")
@Data
public class PeliSerieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String titulo;

    @Column(name = "fecha_estreno")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    private int calificacion;



    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id",insertable = false,updatable = false)
    private GeneroEntity genero;

   //@Column(name = "genero_id",nullable = false);
 //private Long generoId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "personaje_peliserie",
            joinColumns=@JoinColumn(name = "peliserie_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private Set<PersonajeEntity> personajes = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(getClass()!= obj.getClass())
            return false;
        final PeliSerieEntity other = (PeliSerieEntity) obj;
        return other.id == this.id;
    }

}
