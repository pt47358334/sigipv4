package pe.com.pihuicho.sigip.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.pihuicho.sigip.app.model.PedidoDetalleEntity;


@Repository
public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalleEntity, Integer>{

	public List<PedidoDetalleEntity> findAllByPedidoCodigo( Integer pedidoId);
}
