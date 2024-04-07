package rupp.com.kh.cms.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rupp.com.kh.cms.dto.EmployeeDTO;
import rupp.com.kh.cms.dto.SupplierDTO;
import rupp.com.kh.cms.entities.EmployeeEntity;
import rupp.com.kh.cms.entities.SupplierEntity;
import rupp.com.kh.cms.repositories.SupplierRepository;
import rupp.com.kh.cms.services.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired SupplierRepository supplierRepository;

    @Override
    public void deleteSupplier(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteSupplier'");
    }

    @Override
    public SupplierDTO retrieveSupplier(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'retrieveSupplier'");
    }

    @Override
    public List<SupplierDTO> retrieveAllSupplier() {
        List<SupplierDTO> supplierDTOs = new ArrayList<>();
        List<SupplierEntity> sup = supplierRepository.findAll();
        for(SupplierEntity s : sup){
            EmployeeDTO createdByRes = new EmployeeDTO();
            EmployeeDTO updatedByRes = new EmployeeDTO();
            EmployeeEntity createdBy = s.getCreatedBy();
            EmployeeEntity updatedBy = s.getUpdatedBy();
            if(createdBy != null) {
                createdByRes.setFullName(createdBy.getFullName());
                createdByRes.setEmpId(createdBy.getId());
            }
            if(updatedBy != null) {
                updatedByRes.setFullName(updatedBy.getFullName());
                updatedByRes.setEmpId(updatedBy.getId());
            }
            supplierDTOs.add(new SupplierDTO(
                s.getId(),
                s.getName(),
                s.getPhone(),
                s.getEmail(),
                s.getAdress(),
                s.getCreatedAt(),
                s.getUpdatedAt(),
                createdByRes,
                updatedByRes
            ));
        }
        return supplierDTOs;
    }

    @Override
    public void updateSupplier(SupplierDTO supplier, Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'updateSupplier'");
    }

    @Override
    public void createSupplier(SupplierDTO supplier) {
        throw new UnsupportedOperationException("Unimplemented method 'createSupplier'");
    }


    
}