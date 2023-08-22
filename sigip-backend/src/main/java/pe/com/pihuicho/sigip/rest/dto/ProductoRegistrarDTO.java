package pe.com.pihuicho.sigip.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ProductoRegistrarDTO {
	private String titulo;
	private String descripcion;
	private Double precio;
	private String urlImagen;
	private Integer codigoCategoria;
}
