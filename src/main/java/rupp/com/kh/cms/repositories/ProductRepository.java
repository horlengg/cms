package rupp.com.kh.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rupp.com.kh.cms.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    
}
