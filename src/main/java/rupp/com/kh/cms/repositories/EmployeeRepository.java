package rupp.com.kh.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rupp.com.kh.cms.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    
    Boolean existsByPhone(String phone);
    Boolean existsByIdNo(String idNo);
    
}
