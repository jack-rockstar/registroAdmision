package proyecto.pontificia.mi.registroadmision.api.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proyecto.pontificia.mi.registroadmision.api.model.Examen;
import proyecto.pontificia.mi.registroadmision.api.model.Preguntas;
import proyecto.pontificia.mi.registroadmision.api.repository.ExamenRepository;
import proyecto.pontificia.mi.registroadmision.api.repository.PreguntasRepository;

import java.util.List;

@Service
public class PreguntasServiceImpl implements PreguntasService {
    @Autowired
    private PreguntasRepository preguntasRepository;

    @Autowired
    private ExamenRepository examenRepository;


    @Override
    public Preguntas registrarPreguntas(Preguntas preguntas) {
        try {
            Preguntas preguntaNueva = new Preguntas();

            preguntaNueva.setDescPregunta(preguntas.getDescPregunta());
            preguntaNueva.setDescRespuesta(preguntas.getDescRespuesta());
            Examen examen = examenRepository.findById(preguntas.getExamen().getId()).orElseThrow(() -> new RuntimeException("Examen no encontrado"));

            preguntaNueva.setExamen(examen);

            return preguntasRepository.save(preguntaNueva);
        }catch (Exception e){
            throw new EntityNotFoundException("Error pregunta", e);
        }
    }

    @Override
    public List<Preguntas> obtenerPreguntas(Pageable pageable) {
        try {
            Page<Preguntas> preguntas = preguntasRepository.findAll(pageable);
            return preguntas.getContent();
        }catch (Exception e){
            e.printStackTrace();
            throw new EntityNotFoundException("Error pregunta", e);
        }
    }

    @Override
    public Preguntas actualizarPreguntas(Integer id, Preguntas preguntas) {
        try {
            Preguntas preguntaActual = preguntasRepository.findById(id).orElseThrow(() -> new RuntimeException("Preguntas no encontrado"));

            preguntaActual.setDescPregunta(preguntas.getDescPregunta());
            preguntaActual.setDescRespuesta(preguntas.getDescRespuesta());
            preguntaActual.setExamen(preguntas.getExamen());
            return preguntasRepository.save(preguntaActual);
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public Preguntas eliminarPreguntas(Integer id) {
        try {
            Preguntas preguntas = preguntasRepository.findById(id).orElseThrow(() -> new RuntimeException("Preguntas no encontrado"));
            preguntasRepository.deleteById(id);
            return preguntas;
        }catch (Exception e){
            return  null;
        }
    }
}
