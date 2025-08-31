package co.edu.uniajc.sgrc.controller;

import co.edu.uniajc.model.CanchaModel;
import co.edu.uniajc.sgrc.service.CanchaService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canchas")
public class CanchaController {

    private final CanchaService canchaService;

    @Autowired
    public CanchaController(CanchaService canchaService) {
        this.canchaService = canchaService;
    }

    // Crear cancha
    @PostMapping("/save")
    public CanchaModel saveCancha(@RequestBody CanchaModel canchaModel) {
        return canchaService.createCancha(canchaModel);
    }

    // Actualizar cancha
    @PutMapping("/update")
    public CanchaModel updateCancha(@RequestBody CanchaModel canchaModel) {
        return canchaService.updateCancha(canchaModel);
    }

    // Eliminar cancha
    @DeleteMapping("/delete")
    public void deleteCancha(@RequestParam(name = "id") Long id) {
        canchaService.deleteCancha(id);
    }

    // Listar todas las canchas
    @GetMapping("/all")
    public List<CanchaModel> findAllCanchas() {
        return canchaService.findAllCanchas();
    }

    // Buscar canchas por nombre
    @GetMapping("/all/nombre")
    public List<CanchaModel> findAllByNombre(@RequestParam(name = "nombre") String nombre) {
        return canchaService.findAllByNombre(nombre);
    }

    // Buscar canchas por estado
    @GetMapping("/all/estado")
    public List<CanchaModel> findAllByEstado(@RequestParam(name = "estado") String estado) {
        return canchaService.findAllByEstado(estado);
    }

    // Buscar cancha por ID
    @GetMapping("/id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "Cancha no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<CanchaModel> findById(@RequestParam(name = "id") Long id) throws Exception {
        return ResponseEntity.ok(
                canchaService.findById(id)
                        .orElseThrow(() -> new Exception("Cancha no encontrada"))
        );
    }
}
//Mensaje nuevo
//Sebastian

