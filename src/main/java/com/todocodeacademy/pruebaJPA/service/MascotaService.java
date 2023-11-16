package com.todocodeacademy.pruebaJPA.service;

import com.todocodeacademy.pruebaJPA.model.Mascota;
import com.todocodeacademy.pruebaJPA.repository.IMascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService{

    @Autowired
    private IMascotaRepository mascoRepo;
    
    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = mascoRepo.findAll();
        return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota masco) {
        mascoRepo.save(masco);
    }

    @Override
    public void deleteMascota(Long id) {
       mascoRepo.deleteById(id);
    }

    @Override
    public Mascota findMascota(Long id) {
        Mascota masco = mascoRepo.findById(id).orElse(null);
        return masco;
    }

    @Override
    public void editMascota(Long id, Long idNueva, String nuevoNombre,
            String nuevaRaza, String nuevoColor) {
        Mascota masco = this.findMascota(id);
        masco.setId(idNueva);
        masco.setNombre(nuevoNombre);
        masco.setRaza(nuevaRaza);
        masco.setColor(nuevoColor);
        this.saveMascota(masco);
    }

    @Override
    public void editMascota(Mascota masco) {
        this.saveMascota(masco);
    }


    
}
