package pe.com.pihuicho.sigip.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.pihuicho.sigip.rest.dto.PedidoRegistrarDTO;
import pe.com.pihuicho.sigip.rest.dto.RespuestaDTO;
import pe.com.pihuicho.sigip.service.PedidoService;

@RestController()
@RequestMapping("/pedido")
public class PedidoRestController {

	@Autowired
	private PedidoService service;
	
	@GetMapping("/{pedidoId}")
	public ResponseEntity<RespuestaDTO> buscarPorCodigo(@PathVariable Integer pedidoId) throws Exception{		
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Listado con éxito", service.buscarPorCodigo(pedidoId));
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<RespuestaDTO> registrar(@RequestBody PedidoRegistrarDTO dto) throws Exception{
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Registrado con éxito", service.registrar(dto));		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}	
	
}
