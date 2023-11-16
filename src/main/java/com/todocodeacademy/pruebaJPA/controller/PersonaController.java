
package com.todocodeacademy.pruebaJPA.controller;

import com.todocodeacademy.pruebaJPA.model.Persona;
import com.todocodeacademy.pruebaJPA.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    
    //En Java, puedes declarar una variable de tipo de interfaz. Sin embargo, para poder usar esta variable y realizar operaciones en ella o usar sus metodos, necesitarás asignarle una instancia de una clase concreta que implemente esa interfaz en algún momento antes de utilizarla.
    //Pero otra forma común de hacer esto en aplicaciones Spring es a través de la anotación @Autowired, que permite que Spring inyecte automáticamente una instancia concreta en la variable de la interfaz. Por lo que no es necesario instanciar ninguna clase. Y así podremos usar los metodos de esa interfaz.
    @Autowired
    private IPersonaService persoServ;
    
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas(){
        return persoServ.getPersonas();
        //La I tiene metodos abstractos, pero como esos estan sobreescritos en la clase Service, sabe redireccionarlos a ellos.
    }
    
    @GetMapping("/personas/traer/{id}")
    public Persona getPersona(@PathVariable Long id){
        return persoServ.findPersona(id);
    }
    
    
    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona perso){
        persoServ.savePersona(perso);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        persoServ.deletePersona(id);
        return "Persona eliminada correctamente";
    }
    
    //Se usara pathVariable para seleccioanr a la persona a modificar pero para modificar los datos en si usare requestParam para que los datos de la persona no tenga que ponerlso en la url. usaremos required=false para especificar que los parametros no son obligatorios ya que puede que querramos editrar solo un elemento.
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam(required=false, name = "id") Long nuevaId,
            @RequestParam(required=false, name = "nombre") String nuevoNombre,
            @RequestParam(required=false, name = "apellido") String nuevoApellido,
            @RequestParam(required=false, name = "edad") int nuevaEdad){
        persoServ.editPersona(id, nuevaId, nuevoNombre, nuevoApellido, nuevaEdad);
        Persona perso = persoServ.findPersona(nuevaId);
        return perso;
    }
    @PutMapping("/personas/editar")
    public String editPersona(@RequestBody Persona per){
        persoServ.editPersona(per);
        return "Persona editada correctamente";
        
    }
}
