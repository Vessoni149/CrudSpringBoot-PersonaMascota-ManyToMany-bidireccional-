
package com.todocodeacademy.pruebaJPA.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Mascota {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String raza;
    private String color;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
     @JoinTable(
        name = "mascota_persona",
        joinColumns = @JoinColumn(name = "mascota_id", referencedColumnName= "id"),
        inverseJoinColumns = @JoinColumn(name = "persona_id", referencedColumnName= "id")
    )
    private List<Persona> listaPersonas;

    public Mascota(Long id, String nombre, String raza, String color,
            List<Persona> listaPersonas) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.listaPersonas = listaPersonas;
    }

    

    public Mascota() {
    }
    
    
}
