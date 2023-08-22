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

import pe.com.pihuicho.sigip.rest.dto.PromocionRegistrarDTO;
import pe.com.pihuicho.sigip.rest.dto.RespuestaDTO;
import pe.com.pihuicho.sigip.service.PromocionService;

@RestController()
@RequestMapping("/promocion")
public class PromocionRestController {
	
	
	@Autowired
	private PromocionService service;
	
	@GetMapping("")
	public ResponseEntity<RespuestaDTO> listarTodos() throws Exception{		
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Listado con éxito", service.listarTodos());
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@GetMapping("/{promocionId}")
	public ResponseEntity<RespuestaDTO> buscarPorCodigo(@PathVariable Integer promocionId) throws Exception{		
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Listado con éxito", service.buscarPorCodigo(promocionId));
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<RespuestaDTO> registrar(@RequestBody PromocionRegistrarDTO dto) throws Exception{
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Registrado con éxito", service.registrar(dto));		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@PutMapping("/{promocionId}")
	public ResponseEntity<RespuestaDTO> actualizar(@RequestBody PromocionRegistrarDTO dto, @PathVariable Integer promocionId) throws Exception{
		service.actualizar(dto, promocionId);
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Actualizado con éxito", "");		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@DeleteMapping("/{promocionId}")
	public ResponseEntity<RespuestaDTO> eliminar(@PathVariable(name = "promocionId") Integer id) throws Exception{
		service.eliminar(id);
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Eliminado con éxito", ":)");
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
}
