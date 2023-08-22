package pe.com.pihuicho.sigip.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.pihuicho.sigip.app.model.PedidoEntity;


@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer>{

}
