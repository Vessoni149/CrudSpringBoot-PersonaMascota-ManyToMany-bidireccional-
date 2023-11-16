package com.todocodeacademy.pruebaJPA.repository;
import com.todocodeacademy.pruebaJPA.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//La inyeccion de dep siempre se ahce en una interfaz y hay una clase que se encarga de implementar c/u de los metodos. 
//Pero en este caso vamos a hacer algo inverso. vamos a hacer que esta I extienda de una clase especial JPARepository, que ya tiene implementados todos los metodos de JPA. 
//Esto se ahce para no tener que crear una clase que tenga que implementar todos los metodos de jpa.

//Como la I extiende de JpaRepository, el repository va a ser la interfaz. Esto solo por usar Jpa, porque si no la @Repository deberia ir en la clase, no en la I.
@Repository
public interface IPersonaRepository extends JpaRepository <Persona, Long>{
    //JpaRepository tiene 2 parametros, 1 la clase que queremos mapear y 2 el tipo de dato del id de la clase que vamos a mapear.
}
