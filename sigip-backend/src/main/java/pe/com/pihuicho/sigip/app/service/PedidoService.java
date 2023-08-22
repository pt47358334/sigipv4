package pe.com.pihuicho.sigip.app.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.com.pihuicho.sigip.app.model.PedidoEntity;
import pe.com.pihuicho.sigip.app.repository.PedidoRepository;
import pe.com.pihuicho.sigip.app.rest.dto.PedidoRegistrarDTO;

@Service
public class PedidoService {

	@Autowired 
	private PedidoRepository repository;
	
	public PedidoEntity buscarPorCodigo(Integer pedidoId) throws Exception{
		Optional<PedidoEntity> optional = repository.findById(pedidoId);
		
		PedidoEntity pedidoEntity = null;
		if(optional.isPresent()) {
			pedidoEntity = optional.get();
		}
		
		return pedidoEntity;
	}
		
	@Transactional(rollbackOn = Exception.class)
	public PedidoEntity registrar(PedidoRegistrarDTO dto) throws Exception{
		System.out.println("PedidoEntity.registrar: " + dto);		
		PedidoEntity entity = new PedidoEntity();
		entity.setCliente(dto.getCliente());
		entity.setFecha(new Date());
		repository.save(entity);
		
		System.out.println("PedidoId generado: " + entity.getCodigo());
				
		return buscarPorCodigo(entity.getCodigo());
	}
	
}
