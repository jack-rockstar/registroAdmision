package proyecto.pontificia.mi.registroadmision.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proyecto.pontificia.mi.registroadmision.api.model.Distrito;
import proyecto.pontificia.mi.registroadmision.api.repository.DistritoRepository;


import java.util.List;

@Service
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    private DistritoRepository distritoRepository;
    @Override
    public Distrito registrarDistrito(Distrito distrito) {
        try {
            Distrito distritoNuevo = new Distrito();

            distritoNuevo.setNombreDistrito(distrito.getNombreDistrito());
            distritoNuevo.setIdProvincia(distrito.getIdProvincia());

            return distritoRepository.save(distritoNuevo);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Distrito> obtenerDistrito(Pageable pageable) {
        try {
            Page<Distrito> distritos = distritoRepository.findAll(pageable);
            return distritos.getContent();
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public Distrito actualizarDistrito(Integer id, Distrito distrito) {
        try {
            Distrito distritoActual = distritoRepository.findById(id).orElseThrow(() -> new RuntimeException("Distrito no encontrado"));

            distritoActual.setNombreDistrito(distrito.getNombreDistrito());
            distritoActual.setIdProvincia(distrito.getIdProvincia());

            return distritoRepository.save(distritoActual);
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public Distrito eliminarDistrito(Integer id) {
        try {
            Distrito distrito = distritoRepository.findById(id).orElseThrow(() -> new RuntimeException("Distrito no encontrado"));
            distritoRepository.deleteById(id);
            return distrito;
        }catch (Exception e){
            return  null;
        }
    }
}
