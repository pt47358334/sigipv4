package pe.com.pihuicho.sigip.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class PromocionDetalleRegistrarDTO {
	private Integer productoId;
	private Integer cantidad;
	private Double precio;
}
