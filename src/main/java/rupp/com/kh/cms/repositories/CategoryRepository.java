package rupp.com.kh.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rupp.com.kh.cms.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    
}
