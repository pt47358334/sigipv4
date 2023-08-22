package pe.com.pihuicho.sigip.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.pihuicho.sigip.app.rest.dto.PromocionDetalleRegistrarDTO;
import pe.com.pihuicho.sigip.app.rest.dto.RespuestaDTO;
import pe.com.pihuicho.sigip.app.service.PromocionDetalleService;

@RestController()
@RequestMapping("/promocion_detalle")
public class PromocionDetalleRestController {

	@Autowired
	private PromocionDetalleService service;
	
	@PostMapping("/{promocionId}")
	public ResponseEntity<RespuestaDTO> registrar(@RequestBody PromocionDetalleRegistrarDTO dto, @PathVariable Integer promocionId) throws Exception{		
		service.registrar(dto, promocionId);
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Registrado con éxito", "");		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@DeleteMapping("/{promocionId}")
	public ResponseEntity<RespuestaDTO> eliminar(@PathVariable(name = "promocionId") Integer id) throws Exception{
		service.eliminar(id);
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Eliminado con éxito", ":)");
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	
}
