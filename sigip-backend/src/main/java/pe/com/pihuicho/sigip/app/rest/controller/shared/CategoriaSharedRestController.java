package pe.com.pihuicho.sigip.app.rest.controller.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.pihuicho.sigip.app.rest.dto.RespuestaDTO;
import pe.com.pihuicho.sigip.app.service.CategoriaService;

@RestController()
@RequestMapping("/api/shared/categoria")
public class CategoriaSharedRestController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping("")
	public ResponseEntity<RespuestaDTO> listarCategorias() throws Exception{		
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Listado con éxito", service.listarCategorias());
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
}
