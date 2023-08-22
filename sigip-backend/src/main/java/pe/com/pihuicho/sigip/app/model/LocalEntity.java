package pe.com.pihuicho.sigip.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "local")
@Data
@NoArgsConstructor
public class LocalEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name="local_id")
    private Integer codigo;
    
    @Column
    private String titulo;
    
    @Column
    private String direccion;
    
    @Column
    private String telefono;
    
    @Column
    private String latitud;
    
    @Column
    private String longitud;
    
    @Column(name="url_maps")
    private String urlMaps;
    
    @Column(name="url_imagen")
	private String urlImagen;    

}
