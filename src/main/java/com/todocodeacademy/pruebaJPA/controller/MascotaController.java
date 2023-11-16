
package com.todocodeacademy.pruebaJPA.controller;

import com.todocodeacademy.pruebaJPA.model.Mascota;
import com.todocodeacademy.pruebaJPA.service.IMascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {
    
    @Autowired
    private IMascotaService mascoServ;
    
     @GetMapping("/mascotas/traer")
    public List<Mascota> getMascotas(){
        return mascoServ.getMascotas();
    }
    
    @GetMapping("/mascotas/traer/{id}")
    public Mascota getMascota(@PathVariable Long id){
        return mascoServ.findMascota(id);
    }
    
    @PostMapping("/mascotas/crear")
    public String saveMascota(@RequestBody Mascota masco){
        mascoServ.saveMascota(masco);
        return "Mascota creada correctamente";
    }
    
    @PutMapping("/mascotas/editar")
    public String editMascota(@RequestBody Mascota masco){
        mascoServ.editMascota(masco);
        return "Mascota editada correctamente";
    }
}
