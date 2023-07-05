package proyecto.pontificia.mi.registroadmision.api.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proyecto.pontificia.mi.registroadmision.api.model.Carreras;
import proyecto.pontificia.mi.registroadmision.api.model.Departamento;
import proyecto.pontificia.mi.registroadmision.api.model.TipoEducacion;
import proyecto.pontificia.mi.registroadmision.api.repository.CarrerasRepository;
import proyecto.pontificia.mi.registroadmision.api.repository.TipoEducacionRepository;

import java.util.List;

@Service
public class CarrerasServiceImpl implements CarrerasService {

    @Autowired
    private CarrerasRepository carrerasRepository;

    @Autowired
    private TipoEducacionRepository tipoEducacionRepository;

    @Override
    public Carreras registrarCarreras(Carreras carreras) {
        try {
            Carreras carrerasNuevo = new Carreras();

            carrerasNuevo.setNombreCarrera(carreras.getNombreCarrera());
            TipoEducacion tipoEducacion = tipoEducacionRepository.findById(carreras.getTipoEducacion().getId()).orElseThrow(() -> new RuntimeException("Tipo Educacion no encontrado"));
            carrerasNuevo.setTipoEducacion(tipoEducacion);

            return carrerasRepository.save(carrerasNuevo);
        } catch (Exception e) {
            throw new EntityNotFoundException(e);
        }
    }

    @Override
    public List<Carreras> obtenerCarreras(Pageable pageable) {
        try {
            Page<Carreras> carreras = carrerasRepository.findAll(pageable);
            return carreras.getContent();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Carreras obtenerCarreraById(Integer id) {
        try {
            Carreras carreras = carrerasRepository.findById(id).orElseThrow(() -> new RuntimeException("Carreras no encontrado"));
            return carreras;
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public Carreras actualizarCarreras(Integer id, Carreras carreras) {
        try {
            Carreras carrerasActuales = carrerasRepository.findById(id).orElseThrow(() -> new RuntimeException("Carreras no encontrado"));

            carrerasActuales.setNombreCarrera(carreras.getNombreCarrera());
            carrerasActuales.setTipoEducacion(carreras.getTipoEducacion());

            return carrerasRepository.save(carrerasActuales);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Carreras eliminarCarreras(Integer id) {
        try {
            Carreras carreras = carrerasRepository.findById(id).orElseThrow(() -> new RuntimeException("Carreras no encontrado"));
            carrerasRepository.deleteById(id);
            return carreras;
        } catch (Exception e) {
            return null;
        }
    }
}
