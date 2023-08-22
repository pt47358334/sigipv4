package pe.com.pihuicho.sigip.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.com.pihuicho.sigip.app.model.ProductoEntity;
import pe.com.pihuicho.sigip.app.model.PromocionDetalleEntity;
import pe.com.pihuicho.sigip.app.model.PromocionEntity;
import pe.com.pihuicho.sigip.app.repository.PromocionDetalleRepository;
import pe.com.pihuicho.sigip.app.rest.dto.PromocionDetalleRegistrarDTO;

@Service
public class PromocionDetalleService {

	@Autowired 
	private PromocionDetalleRepository repository;
	
	public List<PromocionDetalleEntity> listarPorPromocion(Integer promocionId) throws Exception{		
		return repository.findAllByPromocionCodigo(promocionId);
	}
		
	@Transactional(rollbackOn = Exception.class)
	public void registrar(PromocionDetalleRegistrarDTO dto, Integer promocionId) throws Exception{
		System.out.println("PromocionDetalleService.registrar: " + dto);		
		PromocionDetalleEntity entity = new PromocionDetalleEntity();
		entity.setPromocion(new PromocionEntity(promocionId));
		entity.setProducto(new ProductoEntity(dto.getProductoId()));
		entity.setCantidad(dto.getCantidad());
		entity.setPrecio(dto.getPrecio());
		repository.save(entity);
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void eliminar(Integer id) throws Exception{
		System.out.println("PromocionDetalleService.eliminar: " + id);		
		Optional<PromocionDetalleEntity> registro= repository.findById(id);
		if(registro.isPresent()) {
			repository.delete(registro.get());
		}
	}
	
	
}
