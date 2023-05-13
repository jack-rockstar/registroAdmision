package proyecto.pontificia.mi.registroadmision.api.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proyecto.pontificia.mi.registroadmision.api.model.Examen;
import proyecto.pontificia.mi.registroadmision.api.model.TipoEducacion;
import proyecto.pontificia.mi.registroadmision.api.repository.ExamenRepository;
import proyecto.pontificia.mi.registroadmision.api.repository.TipoEducacionRepository;

import java.util.List;

@Service
public class ExamenServiceImpl implements ExamenService {
    @Autowired
    private ExamenRepository examenRepository;

    @Override
    public Examen registrarExamen(Examen examen) {
        try {
            Examen examenNuevo = new Examen();

            examenNuevo.setFechaInicio(examen.getFechaInicio());
            examenNuevo.setFechaFin(examen.getFechaFin());
            examenNuevo.setPrecioExamen(examen.getPrecioExamen());

            return examenRepository.save(examenNuevo);
        }catch (Exception e){
            throw new EntityNotFoundException("Error Examen", e);
        }
    }

    @Override
    public List<Examen> obtenerExamen(Pageable pageable) {
        try {
            Page<Examen> examen = examenRepository.findAll(pageable);
            return examen.getContent();
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public Examen actualizarExamen(Integer id, Examen examen) {
        try {
            Examen examenActual = examenRepository.findById(id).orElseThrow(() -> new RuntimeException("Examen no encontrado"));

            examenActual.setFechaInicio(examen.getFechaInicio());
            examenActual.setFechaFin(examen.getFechaFin());
            examenActual.setPrecioExamen(examen.getPrecioExamen());
            return examenRepository.save(examenActual);
        }catch (Exception e){
            throw new EntityNotFoundException("Error examen", e);

        }
    }

    @Override
    public Examen eliminarExamen(Integer id) {
        try {
            Examen examen = examenRepository.findById(id).orElseThrow(() -> new RuntimeException("Examen no encontrado"));
            examenRepository.deleteById(id);
            return examen;
        }catch (Exception e){
            throw new EntityNotFoundException("Error Examen", e);
        }
    }
}
