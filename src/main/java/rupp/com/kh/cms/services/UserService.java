package rupp.com.kh.cms.services;

import java.util.List;

import rupp.com.kh.cms.dto.response.UserResponseDTO;

public interface UserService {
    List<UserResponseDTO> retrieveAllUser();
}
