package pe.com.pihuicho.sigip.app.rest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pe.com.pihuicho.sigip.app.model.PromocionDetalleEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PromocionDTO {
	
	private Integer codigo;	
	private String titulo;
	private String urlImagen;
    private List<PromocionDetalleEntity> productos;
	private Double precio;		
	
}
