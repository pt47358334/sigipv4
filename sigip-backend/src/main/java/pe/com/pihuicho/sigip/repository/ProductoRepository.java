package pe.com.pihuicho.sigip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.pihuicho.sigip.model.ProductoEntity;


@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer>{

	public List<ProductoEntity> findAllByCategoriaCodigo( Integer categoriaId);
}
