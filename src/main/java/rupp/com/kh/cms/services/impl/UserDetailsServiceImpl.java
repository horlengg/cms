package rupp.com.kh.cms.services.impl;

import java.util.HashSet;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rupp.com.kh.cms.dto.CurrentUserDetailDTO;
import rupp.com.kh.cms.entities.UserEntity;
import rupp.com.kh.cms.repositories.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException("Invalid username or password");
        else {
            CurrentUserDetailDTO userDetailDTO = new CurrentUserDetailDTO(user.getEmail(),user.getPassword(),new HashSet<>());
            userDetailDTO.setId(user.getId());
            userDetailDTO.setEmployee(user.getEmployee());
            userDetailDTO.setRole(user.getRole());
            user.getPassword();
            return userDetailDTO;
        }

    }

}
