package pe.com.pihuicho.sigip.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.com.pihuicho.sigip.model.CategoriaEntity;
import pe.com.pihuicho.sigip.model.ProductoEntity;
import pe.com.pihuicho.sigip.repository.ProductoRepository;
import pe.com.pihuicho.sigip.rest.dto.ProductoRegistrarDTO;

@Service
public class ProductoService {

	@Autowired 
	private ProductoRepository repository;
	
	public List<ProductoEntity> listarPorCategoria(Integer codigoCategoria) throws Exception{		
		return repository.findAllByCategoriaCodigo(codigoCategoria);
	}
	
	public List<ProductoEntity> listarTodos() throws Exception{		
		return repository.findAll();
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void registrar(ProductoRegistrarDTO dto) throws Exception{
		System.out.println("ProductoService.registrar: " + dto);		
		ProductoEntity entity = new ProductoEntity();
		entity.setTitulo(dto.getTitulo());
		entity.setDescripcion(dto.getDescripcion());
		entity.setPrecio(dto.getPrecio());
		entity.setUrlImagen(dto.getUrlImagen());
		entity.setCategoria(new CategoriaEntity(dto.getCodigoCategoria()));
		repository.save(entity);
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void actualizar(ProductoRegistrarDTO dto, Integer productoId) throws Exception{
		System.out.println("ProductoService.actualizar: " + dto);
		Optional<ProductoEntity> registro= repository.findById(productoId);
		if(registro.isPresent()) {
			ProductoEntity productoEntity = registro.get();
			productoEntity.setTitulo(dto.getTitulo());
			productoEntity.setDescripcion(dto.getDescripcion());
			productoEntity.setPrecio(dto.getPrecio());
			productoEntity.setUrlImagen(dto.getUrlImagen());
			productoEntity.setCategoria(new CategoriaEntity(dto.getCodigoCategoria()));
			repository.save(productoEntity);
		}else {
			throw new RuntimeException("Código no existe: "+productoId+".");
		}
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void eliminar(Integer productoId) throws Exception{
		System.out.println("ProductoService.eliminar: " + productoId);		
		Optional<ProductoEntity> registro= repository.findById(productoId);
		if(registro.isPresent()) {
			repository.delete(registro.get());
		}else {
			throw new RuntimeException("Código no existe: "+productoId+".");
		}
	}
	
	
	
}
