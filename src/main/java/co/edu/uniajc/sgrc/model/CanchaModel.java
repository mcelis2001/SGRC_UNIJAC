@AllArgsConstructor
@Entity 
@Table(name='canchas')
public class CanchaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cancha")
    private Long id;

    @Column(name = "nombre")
    private String nombre; //Nombre de la cancha

    @Column(name = "tipo")
    private String tipo; // futbol, tenis, baloncesto

    @Column(name = "capacidad")
    private Integer capacidad; // Capacidad de personas

    @Column(name = "descripcion", length = 255)
    private String descripcion; // Descripcion de la cancha

    @Column(name = "estado")
    private String estado; // disponible, mantenimiento, reservada

}