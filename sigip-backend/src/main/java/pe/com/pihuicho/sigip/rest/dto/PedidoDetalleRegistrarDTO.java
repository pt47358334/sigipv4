package pe.com.pihuicho.sigip.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class PedidoDetalleRegistrarDTO {
	private Integer productoId;
	private Integer cantidad;
	private String observaciones;
}
