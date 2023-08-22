package pe.com.pihuicho.sigip.app.rest.controller.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.pihuicho.sigip.app.rest.dto.RespuestaDTO;
import pe.com.pihuicho.sigip.app.service.ProductoService;

@RestController()
@RequestMapping("/api/shared/producto")
public class ProductoSharedRestController {

	@Autowired
	private ProductoService service;
	
	@GetMapping("/{codigoCategoria}")
	public ResponseEntity<RespuestaDTO> listarPorCategoria(@PathVariable Integer codigoCategoria) throws Exception{		
		RespuestaDTO respuesta = new RespuestaDTO("OK", "Listado con éxito", service.listarPorCategoria(codigoCategoria));
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}	
}
