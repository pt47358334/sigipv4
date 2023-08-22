package pe.com.pihuicho.sigip.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.com.pihuicho.sigip.model.LocalEntity;
import pe.com.pihuicho.sigip.repository.LocalRepository;
import pe.com.pihuicho.sigip.rest.dto.LocalRegistrarDTO;
@Service
public class LocalService {
	
	@Autowired 
	private LocalRepository repository;
	
	public List<LocalEntity>listarTodos()throws Exception{
		return repository.findAll();
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void registrar(LocalRegistrarDTO dto) throws Exception{
		System.out.println("LocalesService.registrar:" + dto);
		LocalEntity localesentity = new LocalEntity();
		localesentity.setTitulo(dto.getTitulo());
		localesentity.setDireccion(dto.getDireccion());
		localesentity.setTelefono(dto.getTelefono());
		localesentity.setLatitud(dto.getLatitud());
		localesentity.setLongitud(dto.getLongitud());
		localesentity.setUrlMaps(dto.getUrlMaps());		
		localesentity.setUrlImagen(dto.getUrlImagen());
		repository.save(localesentity);
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void actualizar(LocalRegistrarDTO dto, Integer localId) throws Exception{
		System.out.println("LocalesService.registrar:" + dto);
		Optional<LocalEntity> registro= repository.findById(localId);
		if(registro.isPresent()) {
			LocalEntity localesentity = registro.get();
			localesentity.setTitulo(dto.getTitulo());
			localesentity.setDireccion(dto.getDireccion());
			localesentity.setTelefono(dto.getTelefono());
			localesentity.setLatitud(dto.getLatitud());
			localesentity.setLongitud(dto.getLongitud());
			localesentity.setUrlMaps(dto.getUrlMaps());
			localesentity.setUrlImagen(dto.getUrlImagen());
			repository.save(localesentity);
		}else {
			throw new RuntimeException("Código no existe: "+localId+".");
		}		
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void eliminar(Integer localId) throws Exception{
		System.out.println("LocalesService.eliminar:" + localId);
		Optional<LocalEntity> registro= repository.findById(localId);
		if(registro.isPresent()) {
			repository.delete(registro.get());
		}else {
			throw new RuntimeException("Código no existe: "+localId+".");
		}
	}

}
