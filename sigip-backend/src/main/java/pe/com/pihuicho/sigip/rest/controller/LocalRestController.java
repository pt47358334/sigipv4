package pe.com.pihuicho.sigip.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.pihuicho.sigip.rest.dto.LocalRegistrarDTO;
import pe.com.pihuicho.sigip.rest.dto.RespuestaDTO;
import pe.com.pihuicho.sigip.service.LocalService;


@RestController()
@RequestMapping("/local")
public class LocalRestController {

	@Autowired
	private LocalService service;
	
	@GetMapping("")
	public ResponseEntity<RespuestaDTO> listarTodos() throws Exception{		
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Listado con éxito", service.listarTodos());
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<RespuestaDTO> registrar(@RequestBody LocalRegistrarDTO dto) throws Exception{		
		service.registrar(dto);
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Registrado con éxito", "");		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@PutMapping("/{localId}")
	public ResponseEntity<RespuestaDTO> actualizar(@RequestBody LocalRegistrarDTO dto, @PathVariable Integer localId) throws Exception{
		try {
			service.actualizar(dto, localId);
			RespuestaDTO respuesta = new RespuestaDTO("OK", "Actualizado con éxito", "");		
			return new ResponseEntity<>(respuesta, HttpStatus.OK);	
		} catch (Exception e) {
			RespuestaDTO respuesta = new RespuestaDTO("ERROR", e.getMessage(), ":(");
			return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{localId}")
	public ResponseEntity<RespuestaDTO> eliminar(@PathVariable Integer localId) throws Exception{
		try {
			service.eliminar(localId);
			RespuestaDTO respuesta = new RespuestaDTO("OK", "Eliminado con éxito", ":)");
			return new ResponseEntity<>(respuesta, HttpStatus.OK);	
		} catch (Exception e) {
			RespuestaDTO respuesta = new RespuestaDTO("ERROR", e.getMessage(), ":(");
			return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
		}		
	}
}
