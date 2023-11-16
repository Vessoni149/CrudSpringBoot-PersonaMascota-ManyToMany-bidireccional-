package com.todocodeacademy.pruebaJPA.service;
import com.todocodeacademy.pruebaJPA.model.Persona;
import com.todocodeacademy.pruebaJPA.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//El Controller llama al service y éste al repository
@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    private IPersonaRepository persoRepo;
    
    
//Dentro de los metodos usaremos los metodos de Jpa a travez de IpersonaRepository que extiende de la clase JpaRepository
    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = persoRepo.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
      persoRepo.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
       persoRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona perso = persoRepo.findById(id).orElse(null);
        return perso;
    }
    
    
    //El metodo para editar tiene algo particular. Existen varias formas de modificar un objeto. Hay casos en los que el id es un vlor que no se puede modificar. Pero en otros casos el id se debe ingresar manuelmente, y si por error humano se equivoca de id luego se debe modificar. No es buena practica que el id se cree manual y se pueda modificar pero puede pasar.

    @Override
    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre,
            String nuevoApellido, int nuevaEdad) {
        //busco el objeto original:
        Persona perso = this.findPersona(idOriginal);
        //Proceso de modificacion a nivel logico:
        perso.setId(idNueva);
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEdad(nuevaEdad);
        //Algunos proveedores de ORM por ej eclipseLink tienen un metodo edit, al que le mandamos el obj entero y lo modifica. Ese metodo esta deprecado. Hibernate exige que las modiifcaciones las hagamos a nivel logico y que se las pasemos a la DB con el metodo save para que sobreescriba el obj.
        //Guardar cambios:
        this.savePersona(perso);
    }

    @Override
    public void editPersona(Persona per) {
        this.savePersona(per);
    }
    
    
}
