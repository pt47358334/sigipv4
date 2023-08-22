package pe.com.pihuicho.sigip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.pihuicho.sigip.model.LocalEntity;


@Repository
public interface LocalRepository extends JpaRepository<LocalEntity, Integer>{
		
}


