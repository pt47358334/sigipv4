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

import pe.com.pihuicho.sigip.rest.dto.ProductoRegistrarDTO;
import pe.com.pihuicho.sigip.rest.dto.RespuestaDTO;
import pe.com.pihuicho.sigip.service.ProductoService;

@RestController()
@RequestMapping("/producto")
public class ProductoRestController {

	@Autowired
	private ProductoService service;
	
	@GetMapping("")
	public ResponseEntity<RespuestaDTO> listarTodos() throws Exception{		
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Listado con éxito", service.listarTodos());
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@GetMapping("/{codigoCategoria}")
	public ResponseEntity<RespuestaDTO> listarPorCategoria(@PathVariable Integer codigoCategoria) throws Exception{		
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Listado con éxito", service.listarPorCategoria(codigoCategoria));
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<RespuestaDTO> registrar(@RequestBody ProductoRegistrarDTO dto) throws Exception{		
		service.registrar(dto);
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Registrado con éxito", "");		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@PutMapping("/{productoId}")
	public ResponseEntity<RespuestaDTO> actualizar(@RequestBody ProductoRegistrarDTO dto, @PathVariable Integer productoId) throws Exception{
		try {
			service.actualizar(dto, productoId);
			RespuestaDTO respuesta = new RespuestaDTO("OK", "Actualizado con éxito", "");		
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			RespuestaDTO respuesta = new RespuestaDTO("ERROR", e.getMessage(), ":(");
			return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{productoId}")
	public ResponseEntity<RespuestaDTO> eliminar(@PathVariable Integer productoId) throws Exception{
		try {
			service.eliminar(productoId);
			RespuestaDTO respuesta = new RespuestaDTO("OK", "Eliminado con éxito", ":)");
			return new ResponseEntity<>(respuesta, HttpStatus.OK);	
		} catch (Exception e) {
			RespuestaDTO respuesta = new RespuestaDTO("ERROR", e.getMessage(), ":(");
			return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
		}
		
	}
	
}
