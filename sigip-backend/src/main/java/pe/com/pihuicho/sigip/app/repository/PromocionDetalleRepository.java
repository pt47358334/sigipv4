package pe.com.pihuicho.sigip.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.pihuicho.sigip.app.model.PromocionDetalleEntity;


@Repository
public interface PromocionDetalleRepository extends JpaRepository<PromocionDetalleEntity, Integer>{

	public List<PromocionDetalleEntity> findAllByPromocionCodigo( Integer promocionId);
}
