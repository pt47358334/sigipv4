package pe.com.pihuicho.sigip.app.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoriaRegistrarDTO {
	private String nombre;
	private String urlImagen;
}
