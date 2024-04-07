package rupp.com.kh.cms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rupp.com.kh.cms.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByEmail(String email);

    List<UserEntity> findAll();
    
}
