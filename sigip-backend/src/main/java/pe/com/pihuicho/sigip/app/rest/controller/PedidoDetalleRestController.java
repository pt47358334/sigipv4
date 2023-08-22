package pe.com.pihuicho.sigip.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.pihuicho.sigip.app.rest.dto.PedidoDetalleRegistrarDTO;
import pe.com.pihuicho.sigip.app.rest.dto.RespuestaDTO;
import pe.com.pihuicho.sigip.app.service.PedidoDetalleService;

@RestController()
@RequestMapping("/pedido_detalle")
public class PedidoDetalleRestController {

	@Autowired
	private PedidoDetalleService service;
	
	@PostMapping("/{pedidoId}")
	public ResponseEntity<RespuestaDTO> registrar(@RequestBody PedidoDetalleRegistrarDTO dto, @PathVariable Integer pedidoId) throws Exception{		
		service.registrar(dto, pedidoId);
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Registrado con éxito", "");		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}	
	
}
