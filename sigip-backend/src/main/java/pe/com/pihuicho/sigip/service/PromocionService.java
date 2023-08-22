package pe.com.pihuicho.sigip.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.com.pihuicho.sigip.model.PromocionDetalleEntity;
import pe.com.pihuicho.sigip.model.PromocionEntity;
import pe.com.pihuicho.sigip.repository.PromocionRepository;
import pe.com.pihuicho.sigip.rest.dto.PromocionDTO;
import pe.com.pihuicho.sigip.rest.dto.PromocionRegistrarDTO;

@Service
public class PromocionService {

	@Autowired 
	private PromocionRepository repository;
		
	public List<PromocionDTO> listarTodos() throws Exception{
		List<PromocionDTO> resultado = new ArrayList<>();
		List<PromocionEntity> listadoBD = repository.findAll();
		
		resultado = listadoBD.stream()
				.map(s -> new PromocionDTO(s.getCodigo(), s.getTitulo(), s.getUrlImagen(), s.getProductos(), null))
				.collect(Collectors.toList());
		
		resultado.forEach(e->{
			e.setPrecio(e.getProductos().stream().mapToDouble(PromocionDetalleEntity::getPrecio).sum());
		});
		
		return resultado;
	}
	
	public PromocionEntity buscarPorCodigo(Integer promocionId) throws Exception{
		Optional<PromocionEntity> optional = repository.findById(promocionId);
		
		PromocionEntity promocionEntity = null;
		if(optional.isPresent()) {
			promocionEntity = optional.get();
		}
		
		return promocionEntity;
	}
		
	@Transactional(rollbackOn = Exception.class)
	public PromocionEntity registrar(PromocionRegistrarDTO dto) throws Exception{
		System.out.println("PromocionService.registrar: " + dto);		
		PromocionEntity entity = new PromocionEntity();
		entity.setTitulo(dto.getTitulo());
		entity.setUrlImagen(dto.getUrlImagen());
		repository.save(entity);
		
		System.out.println("Id generado: " + entity.getCodigo());
				
		return buscarPorCodigo(entity.getCodigo());
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void actualizar(PromocionRegistrarDTO dto,  Integer id) throws Exception{
		System.out.println("PromocionService.actualizar: " + dto + " id: "+ id);
		Optional<PromocionEntity> registro= repository.findById(id);
		if(registro.isPresent()) {
			PromocionEntity entity = registro.get();
			entity.setTitulo(dto.getTitulo());
			entity.setUrlImagen(dto.getUrlImagen());
			repository.save(entity);	
		}		
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void eliminar(Integer id) throws Exception{
		System.out.println("PromocionService.eliminar: " + id);		
		Optional<PromocionEntity> registro= repository.findById(id);
		if(registro.isPresent()) {
			repository.delete(registro.get());
		}
	}
	
}
