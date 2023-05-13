package proyecto.pontificia.mi.registroadmision.api.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proyecto.pontificia.mi.registroadmision.api.model.Calificaciones;
import proyecto.pontificia.mi.registroadmision.api.model.Examen;
import proyecto.pontificia.mi.registroadmision.api.model.Usuario;
import proyecto.pontificia.mi.registroadmision.api.repository.CalifacionesRepository;
import proyecto.pontificia.mi.registroadmision.api.repository.ExamenRepository;
import proyecto.pontificia.mi.registroadmision.api.repository.UsuarioRepository;

import java.util.List;

@Service
public class CalificacionesServiceImpl implements CalificacionesService {
    @Autowired
    private CalifacionesRepository califacionesRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ExamenRepository examenRepository;

    @Override
    public Calificaciones registrarCalificaciones(Calificaciones califaciones) {
        try {
            Calificaciones califacionNueva = new Calificaciones();

            califacionNueva.setNota(califaciones.getNota());
            Examen examen = examenRepository.findById(califaciones.getExamen().getId()).orElseThrow(() -> new RuntimeException("Examen no encontrado"));
            califacionNueva.setExamen(examen);

            Usuario estudiante = usuarioRepository.findById(califaciones.getEstudiante().getId()).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
            califacionNueva.setEstudiante(estudiante);

            return califacionesRepository.save(califacionNueva);
        }catch (Exception e){
            throw new EntityNotFoundException("Error calificacion", e);
        }
    }

    @Override
    public List<Calificaciones> obtenerCalificaciones(Pageable pageable) {
        try {
            Page<Calificaciones> califaciones = califacionesRepository.findAll(pageable);
            return califaciones.getContent();
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public Calificaciones actualizarCalificaciones(Integer id, Calificaciones califaciones) {
        try {
            Calificaciones calificacionActual = califacionesRepository.findById(id).orElseThrow(() -> new RuntimeException("Calificacion no encontrado"));

            calificacionActual.setNota(califaciones.getNota());
            calificacionActual.setEstudiante(califaciones.getEstudiante());
            calificacionActual.setExamen(califaciones.getExamen());

            return califacionesRepository.save(calificacionActual);
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public Calificaciones eliminarCalificaciones(Integer id) {
        try {
            Calificaciones califaciones = califacionesRepository.findById(id).orElseThrow(() -> new RuntimeException("Calificaciones no encontrado"));
            califacionesRepository.deleteById(id);
            return califaciones;
        }catch (Exception e){
            return  null;
        }
    }
}
