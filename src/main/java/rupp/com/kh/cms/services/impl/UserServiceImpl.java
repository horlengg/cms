package rupp.com.kh.cms.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rupp.com.kh.cms.dto.response.UserResponseDTO;
import rupp.com.kh.cms.entities.UserEntity;
import rupp.com.kh.cms.repositories.UserRepository;
import rupp.com.kh.cms.services.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired UserRepository userRepository;

    @Override
    public List<UserResponseDTO> retrieveAllUser() {
        List<UserResponseDTO> response = new ArrayList<>();
        List<UserEntity> users = userRepository.findAll();
        for(UserEntity user : users) {
            response.add(new UserResponseDTO(user.getEmail(),user.getRole(),user.getCreatedAt(),user.getUpdatedAt()));
        }
        return response;
    }
    
}
