package proyecto.pontificia.mi.registroadmision.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proyecto.pontificia.mi.registroadmision.api.model.TipoEducacion;
import proyecto.pontificia.mi.registroadmision.api.repository.TipoEducacionRepository;

import java.util.List;

@Service
public class TipoEducacionServiceImpl implements TipoEducacionService {
    @Autowired
    private TipoEducacionRepository tipoEducacionRepository;

    @Override
    public TipoEducacion registrarTipoEducacion(TipoEducacion tipoEducacion){
        try {
            TipoEducacion nuevoTipoEducacion = new TipoEducacion();
            nuevoTipoEducacion.setNombre(tipoEducacion.getNombre());
            nuevoTipoEducacion.setNombreCorto(tipoEducacion.getNombreCorto());
            return tipoEducacionRepository.save(nuevoTipoEducacion);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public TipoEducacion actualizarTipoEducacion(Integer id, TipoEducacion tipoEducacion){
        try {
             TipoEducacion tipoEducacionActual = tipoEducacionRepository.findById(id).orElseThrow(() -> new RuntimeException("TipoEducacion no encontrado"));
             tipoEducacionActual.setNombre(tipoEducacion.getNombre());
             tipoEducacionActual.setNombreCorto(tipoEducacion.getNombreCorto());
             return tipoEducacionRepository.save(tipoEducacionActual);
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public TipoEducacion eliminarTipoEducacion(Integer id){
        try {
            TipoEducacion tipoEducacionActual = tipoEducacionRepository.findById(id).orElseThrow(() -> new RuntimeException("TipoEducacion no encontrado"));
            tipoEducacionRepository.deleteById(id);
            return tipoEducacionActual;
        }catch (Exception e){
            return  null;
        }
    }



    @Override
    public List<TipoEducacion> obtenerTiposEducacion(Pageable pageable){
        try {
            Page<TipoEducacion> tipoEducacion = tipoEducacionRepository.findAll(pageable);
            return tipoEducacion.getContent();
        }catch (Exception e){
            return  null;
        }
    }
}
