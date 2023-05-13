package proyecto.pontificia.mi.registroadmision.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proyecto.pontificia.mi.registroadmision.api.model.Departamento;
import proyecto.pontificia.mi.registroadmision.api.repository.DepartamentoRepository;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public Departamento registrarDepartamento(Departamento Departamento) {
        try {
            Departamento depaNuevo = new Departamento();

            depaNuevo.setNombreDepartamento(Departamento.getNombreDepartamento());
            return departamentoRepository.save(depaNuevo);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Departamento> obtenerDepartamento(Pageable pageable) {
        try {
            Page<Departamento> departamentos = departamentoRepository.findAll(pageable);
            return departamentos.getContent();
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public Departamento actualizarDepartamento(Integer id, Departamento Departamento) {
        try {
            Departamento departamentoActual = departamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

            departamentoActual.setNombreDepartamento(Departamento.getNombreDepartamento());
            return departamentoRepository.save(departamentoActual);
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public Departamento eliminarDepartamento(Integer id) {
        try {
            Departamento departamento = departamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
            departamentoRepository.deleteById(id);
            return departamento;
        }catch (Exception e){
            return  null;
        }
    }
}
