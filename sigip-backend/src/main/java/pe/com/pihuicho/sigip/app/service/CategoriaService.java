package pe.com.pihuicho.sigip.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.com.pihuicho.sigip.app.model.CategoriaEntity;
import pe.com.pihuicho.sigip.app.repository.CategoriaRepository;
import pe.com.pihuicho.sigip.app.rest.dto.CategoriaRegistrarDTO;

@Service
public class CategoriaService {

	@Autowired 
	private CategoriaRepository repository;
	
	public List<CategoriaEntity> listarCategorias() throws Exception{
		return repository.findAll();
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void registrar(CategoriaRegistrarDTO dto) throws Exception{
		System.out.println("CategoriaService.registrar: " + dto);		
		CategoriaEntity categoriaEntity = new CategoriaEntity();
		categoriaEntity.setNombre(dto.getNombre());
		categoriaEntity.setUrlImagen(dto.getUrlImagen());
		repository.save(categoriaEntity);
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void actualizar(CategoriaRegistrarDTO dto,  Integer categoriaId) throws Exception{
		System.out.println("CategoriaService.actualizar: " + dto + " id: "+ categoriaId);
		Optional<CategoriaEntity> registro= repository.findById(categoriaId);
		if(registro.isPresent()) {
			CategoriaEntity categoriaEntity = registro.get();
			categoriaEntity.setNombre(dto.getNombre());
			categoriaEntity.setUrlImagen(dto.getUrlImagen());
			repository.save(categoriaEntity);	
		}		
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void eliminar(Integer categoriaId) throws Exception{
		System.out.println("CategoriaService.eliminar: " + categoriaId);		
		Optional<CategoriaEntity> registro= repository.findById(categoriaId);
		if(registro.isPresent()) {
			repository.delete(registro.get());
		}
	}
	
}
