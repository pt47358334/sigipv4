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

import pe.com.pihuicho.sigip.rest.dto.CategoriaRegistrarDTO;
import pe.com.pihuicho.sigip.rest.dto.RespuestaDTO;
import pe.com.pihuicho.sigip.service.CategoriaService;

@RestController()
@RequestMapping("/categoria")
public class CategoriaRestController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping("")
	public ResponseEntity<RespuestaDTO> listarCategorias() throws Exception{		
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Listado con éxito", service.listarCategorias());
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<RespuestaDTO> registrar(@RequestBody CategoriaRegistrarDTO dto) throws Exception{		
		service.registrar(dto);
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Registrado con éxito", "");		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@PutMapping("/{categoriaId}")
	public ResponseEntity<RespuestaDTO> actualizar(@RequestBody CategoriaRegistrarDTO dto, @PathVariable Integer categoriaId) throws Exception{		
		service.actualizar(dto, categoriaId);
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Actualizado con éxito", "");		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@DeleteMapping("/{categoriaId}")
	public ResponseEntity<RespuestaDTO> eliminar(@PathVariable Integer categoriaId) throws Exception{
		service.eliminar(categoriaId);
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Eliminado con éxito", ":)");
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
}
