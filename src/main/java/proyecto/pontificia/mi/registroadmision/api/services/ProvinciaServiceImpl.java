package proyecto.pontificia.mi.registroadmision.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proyecto.pontificia.mi.registroadmision.api.model.Preguntas;
import proyecto.pontificia.mi.registroadmision.api.model.Provincia;
import proyecto.pontificia.mi.registroadmision.api.repository.ProvinciaRepository;

import java.util.List;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public Provincia registrarProvincia(Provincia provincia) {
        try {
            Provincia provinciaNueva = new Provincia();

            provinciaNueva.setNombreProvincia(provincia.getNombreProvincia());
            provinciaNueva.setDepartamento(provincia.getDepartamento());

            return provinciaRepository.save(provinciaNueva);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Provincia> obtenerProvincia(Pageable pageable) {
        try {
            Page<Provincia> provincia = provinciaRepository.findAll(pageable);
            return provincia.getContent();
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public Provincia actualizarProvincia(Integer id, Provincia provincia) {
        try {
            Provincia provinciaActual = provinciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Provincia no encontrado"));

            provinciaActual.setNombreProvincia(provincia.getNombreProvincia());
            provinciaActual.setDepartamento(provincia.getDepartamento());

            return provinciaRepository.save(provinciaActual);
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public Provincia eliminarProvincia(Integer id) {
        try {
            Provincia provincia = provinciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Provincia no encontrado"));
            provinciaRepository.deleteById(id);
            return provincia;
        }catch (Exception e){
            return  null;
        }
    }
}
