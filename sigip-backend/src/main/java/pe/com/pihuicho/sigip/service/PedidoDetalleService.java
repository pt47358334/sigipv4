package pe.com.pihuicho.sigip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.com.pihuicho.sigip.model.PedidoDetalleEntity;
import pe.com.pihuicho.sigip.model.PedidoEntity;
import pe.com.pihuicho.sigip.model.ProductoEntity;
import pe.com.pihuicho.sigip.repository.PedidoDetalleRepository;
import pe.com.pihuicho.sigip.rest.dto.PedidoDetalleRegistrarDTO;

@Service
public class PedidoDetalleService {

	@Autowired 
	private PedidoDetalleRepository repository;
	
	public List<PedidoDetalleEntity> listarPorPedido(Integer pedidoId) throws Exception{		
		return repository.findAllByPedidoCodigo(pedidoId);
	}
		
	@Transactional(rollbackOn = Exception.class)
	public void registrar(PedidoDetalleRegistrarDTO dto, Integer pedidoId) throws Exception{
		System.out.println("PedidoDetalleEntity.registrar: " + dto);		
		PedidoDetalleEntity entity = new PedidoDetalleEntity();
		entity.setPedido(new PedidoEntity(pedidoId));
		entity.setProducto(new ProductoEntity(dto.getProductoId()));
		entity.setCantidad(dto.getCantidad());
		entity.setObservaciones(dto.getObservaciones());
		repository.save(entity);
	}
	
}
