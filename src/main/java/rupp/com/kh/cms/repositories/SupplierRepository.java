package rupp.com.kh.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rupp.com.kh.cms.entities.SupplierEntity;

public interface SupplierRepository extends JpaRepository<SupplierEntity,Long> {
    
}
