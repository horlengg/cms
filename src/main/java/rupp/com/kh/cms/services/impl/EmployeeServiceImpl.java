package rupp.com.kh.cms.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import rupp.com.kh.cms.dto.EmployeeDTO;
import rupp.com.kh.cms.entities.EmployeeEntity;
import rupp.com.kh.cms.exceptions.BadRequestException;
import rupp.com.kh.cms.exceptions.ResourceNotFoundException;
import rupp.com.kh.cms.repositories.EmployeeRepository;
import rupp.com.kh.cms.services.EmployeeService;
import rupp.com.kh.cms.services.FileUploadService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService  {

    @Autowired EmployeeRepository employeeRepository;
    @Autowired FileUploadService fileUploadService;
    
    
    @Override
    public void updateEmployee(Long id,EmployeeDTO emp,MultipartFile file)  throws Exception {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee ID = "+id+" Not Found!.","employee"));
        employee.setId(emp.getEmpId());
        employee.setFullName(emp.getFullName());
        employee.setGender(emp.getGender());
        if(!employee.getPhone().equals(emp.getPhone())) {
            if(employeeRepository.existsByPhone(emp.getPhone()))
                throw new BadRequestException("Phone number is already exist!.","employee");
            else employee.setPhone(emp.getPhone());
        }
        employee.setMaritalStatus(emp.getMaritalStatus());
        employee.setDob(f.parse(emp.getDob()));
        employee.setContractEndDate(f.parse(emp.getContractEndDate()));
        employee.setEffectiveDate(f.parse(emp.getEffectiveDate()));
        if(!employee.getIdNo().equals(emp.getIdNo())) {
            if(employeeRepository.existsByIdNo(emp.getIdNo()))
                throw new BadRequestException("ID number is already exist!.","employee");
            else employee.setIdNo(emp.getIdNo());
        }
        employee.setIdType(emp.getIdType());
        if(!file.isEmpty()) {
            File tempFile = File.createTempFile("temp", null);
            file.transferTo(tempFile);
            String URI = fileUploadService.uploadToGoogleDrive(tempFile);
            if(!fileUploadService.hasDefaultProfileURI(employee.getProfileUrl())) {
                fileUploadService.deleteFileOnGoogleDrive(fileUploadService.getProfileId(employee.getProfileUrl()));
            }
            employee.setProfileUrl(URI);

        }
        employeeRepository.save(employee);
        employee.setPresentAddress(emp.getPresentAddress());
    }

    @Override
    public void createEmployee(EmployeeDTO employee,MultipartFile file) throws ParseException, IOException {
        EmployeeEntity emp = new EmployeeEntity();
        SimpleDateFormat simpleDateFormate = new SimpleDateFormat("yyyy-MM-dd");
        emp.setFullName(employee.getFullName());
        emp.setGender(employee.getGender());
        if(!employee.getPhone().equals(emp.getPhone())) {
            if(employeeRepository.existsByPhone(employee.getPhone()))
                throw new BadRequestException("Phone number is already exist!.","employee");
            else emp.setPhone(employee.getPhone());
        }
        emp.setMaritalStatus(employee.getMaritalStatus());
        if(!employee.getIdNo().equals(emp.getIdNo())) {
            if(employeeRepository.existsByIdNo(employee.getIdNo()))
                throw new BadRequestException("ID number is already exist!.","employee");
            else emp.setIdNo(employee.getIdNo());
        }
        emp.setIdType(employee.getIdType());
        emp.setEffectiveDate(simpleDateFormate.parse(employee.getEffectiveDate()));
        emp.setContractEndDate(simpleDateFormate.parse(employee.getContractEndDate()));
        emp.setDob(simpleDateFormate.parse(employee.getDob()));
        emp.setPresentAddress(employee.getPresentAddress());
        emp.setIsDeleted(false);

        if(file.isEmpty()) emp.setProfileUrl(fileUploadService.getDefaultProfileImageURI());
        else {
            File tempFile = File.createTempFile("temp", null);
            file.transferTo(tempFile);
            String URI = fileUploadService.uploadToGoogleDrive(tempFile);
            emp.setProfileUrl(URI);
        }
        
        employeeRepository.save(emp);
    }

    @Override
    public List<EmployeeDTO> retrieveAllEmployee() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        List<EmployeeDTO> listEmployee = new ArrayList<>();
        for(EmployeeEntity e : employees){
            String dob = null;
            String contractEndDate = null;
            String effectiveDate = null;
            if(e.getDob() != null) 
                dob = e.getDob().toString().split(" ")[0];
            if(e.getContractEndDate() != null) 
                contractEndDate = e.getContractEndDate().toString().split(" ")[0];
            if(e.getEffectiveDate() != null) 
                effectiveDate = e.getEffectiveDate().toString().split(" ")[0];
            EmployeeDTO currentEmployee = EmployeeDTO.builder()
                .empId(e.getId())
                .fullName(e.getFullName())
                .gender(e.getGender())
                .dob(dob)
                .effectiveDate(effectiveDate)
                .contractEndDate(contractEndDate)
                .phone(e.getPhone())
                .idNo(e.getIdNo())
                .idType(e.getIdType())
                .presentAddress(e.getPresentAddress())
                .build();
            listEmployee.add(currentEmployee);
        }
        return listEmployee;
    }

    @Override
    public EmployeeDTO retrieveEmployee(Long id) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee ID = "+id+" Not Found!.","employee"));
        EmployeeDTO empFormDTO = EmployeeDTO
            .builder()
            .empId(employee.getId())
            .fullName(employee.getFullName())
            .gender(employee.getGender())
            .phone(employee.getPhone())
            .dob(f.format(employee.getDob()))
            .contractEndDate(f.format(employee.getContractEndDate()))
            .effectiveDate(f.format(employee.getEffectiveDate()))
            .idNo(employee.getIdNo())
            .idType(employee.getIdType())
            .presentAddress(employee.getPresentAddress())
            .maritalStatus(employee.getMaritalStatus())
            .profileImage(employee.getProfileUrl())
            .build();
        return empFormDTO;
    }

    @Override
    public void deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(String.format("Not found employee id : %d", id), "employee"));
        employee.setId(id);
        employee.setIsDeleted(true);
        employeeRepository.save(employee);
    }

    
}
