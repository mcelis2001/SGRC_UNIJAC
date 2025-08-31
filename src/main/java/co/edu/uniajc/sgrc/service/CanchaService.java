package co.edu.uniajc.sgrc.service;

import co.edu.uniajc.model.CanchaModel;
import co.edu.uniajc.sgrc.repository.CanchaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CanchaService {

    private final CanchaRepository canchaRepository;

    @Autowired
    public CanchaService(CanchaRepository canchaRepository) {
        this.canchaRepository = canchaRepository;
    }

    // Crear cancha
    public CanchaModel createCancha(CanchaModel canchaModel) {
        return canchaRepository.save(canchaModel);
    }

    // Actualizar cancha
    public CanchaModel updateCancha(CanchaModel canchaModel) {
        return canchaRepository.save(canchaModel);
    }

    // Listar todas las canchas
    public List<CanchaModel> getAllCanchas() {
        return canchaRepository.findAll();
    }

    // Buscar cancha por ID
    public Optional<CanchaModel> getCanchaById(Long id) {
        return canchaRepository.findById(id);
    }

    // Eliminar cancha por ID
    public void deleteCancha(Long id) {
        canchaRepository.deleteById(id);
    }

    // Buscar canchas por nombre que contengan un texto
    public List<CanchaModel> searchByNombre(String nombre) {
        return canchaRepository.findAllByNombreContains(nombre);
    }

    // Buscar canchas por estado (disponible, reservada, mantenimiento)
    public List<CanchaModel> searchByEstado(String estado) {
        return canchaRepository.findAllByEstado(estado);
    }
}
