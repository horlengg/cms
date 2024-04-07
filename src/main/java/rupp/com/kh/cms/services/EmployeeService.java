package rupp.com.kh.cms.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

import rupp.com.kh.cms.dto.EmployeeDTO;

public interface EmployeeService {
    void updateEmployee(Long id,EmployeeDTO employee,MultipartFile file)  throws ParseException, IOException, Exception ;
    void createEmployee(EmployeeDTO employee,MultipartFile file)  throws ParseException, IOException;
    List<EmployeeDTO> retrieveAllEmployee();
    EmployeeDTO retrieveEmployee(Long id);
    void deleteEmployee(Long id);
    
}
