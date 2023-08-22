package pe.com.pihuicho.sigip.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.pihuicho.sigip.auth.model.ERole;
import pe.com.pihuicho.sigip.auth.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
