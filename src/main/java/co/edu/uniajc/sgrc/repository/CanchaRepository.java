package co.edu.uniajc.sgrc.repository;

import co.edu.uniajc.model.CanchaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanchaRepository extends JpaRepository<CanchaModel, Long> {

    // Buscar canchas cuyo nombre contenga cierto texto
    List<CanchaModel> findAllByNombreContains(String nombre);

    // Buscar canchas por estado (disponible, reservada, mantenimiento)
    List<CanchaModel> findAllByEstado(String estado);
}