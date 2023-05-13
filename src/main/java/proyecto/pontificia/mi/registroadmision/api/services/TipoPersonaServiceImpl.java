package proyecto.pontificia.mi.registroadmision.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proyecto.pontificia.mi.registroadmision.api.model.TipoPersona;
import proyecto.pontificia.mi.registroadmision.api.repository.TipoPersonaRepository;

import java.util.List;

@Service
public class TipoPersonaServiceImpl implements TipoPersonaService {
    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;
    @Override
    public TipoPersona registrarTipoPersona(TipoPersona tipoPersona) {
        try {
            TipoPersona tipoPersonaNueva = new TipoPersona();

            tipoPersonaNueva.setDescripcion(tipoPersona.getDescripcion());

            return tipoPersonaRepository.save(tipoPersonaNueva);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<TipoPersona> obtenerTiposPersona(Pageable pageable) {
        try {
            Page<TipoPersona> tipoPersonas = tipoPersonaRepository.findAll(pageable);
            return tipoPersonas.getContent();
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public TipoPersona actualizarTipoPersona(Integer id, TipoPersona tipoPersona) {
        try {
            TipoPersona tipoPersonActual = tipoPersonaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tipo Persona no encontrado"));

            tipoPersonActual.setDescripcion(tipoPersona.getDescripcion());

            return tipoPersonaRepository.save(tipoPersonActual);
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public TipoPersona eliminarTipoPersona(Integer id) {
        try {
            TipoPersona tipoPersona = tipoPersonaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tipo persona no encontrado"));
            tipoPersonaRepository.deleteById(id);
            return tipoPersona;
        }catch (Exception e){
            return  null;
        }
    }
}
