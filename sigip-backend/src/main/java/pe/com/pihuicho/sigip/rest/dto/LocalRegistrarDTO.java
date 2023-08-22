package pe.com.pihuicho.sigip.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocalRegistrarDTO {
	private String titulo;
	private String direccion;
	private String telefono;
	private String latitud;
	private String longitud;
	private String urlMaps;
	private String urlImagen;
}
