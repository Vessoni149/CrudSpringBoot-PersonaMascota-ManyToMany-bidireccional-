
package com.todocodeacademy.pruebaJPA.service;

import com.todocodeacademy.pruebaJPA.model.Mascota;
import java.util.List;


public interface IMascotaService {
    public List <Mascota> getMascotas();
    public void saveMascota(Mascota masco);
    public void deleteMascota(Long id);
    public Mascota findMascota(Long id);
    public void editMascota(Long id, Long idNueva, String nuevoNombre, String nuevaRaza, String nuevoColor);

    public void editMascota(Mascota masco);
}
