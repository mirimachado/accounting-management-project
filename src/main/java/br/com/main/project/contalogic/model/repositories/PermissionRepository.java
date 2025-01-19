package br.com.main.project.contalogic.model.repositories;

import br.com.main.project.contalogic.model.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findById(Long id);
    Optional<Permission> findByPermissionName(String permissionName);
    Optional<Permission> findByDescription(String description);

}
