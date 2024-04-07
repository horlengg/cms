package rupp.com.kh.cms.services;

import java.util.List;

import rupp.com.kh.cms.dto.SupplierDTO;

public interface SupplierService {
    void deleteSupplier(Long id);
    SupplierDTO retrieveSupplier(Long id);
    List<SupplierDTO> retrieveAllSupplier();
    void updateSupplier(SupplierDTO supplier,Long id);
    void createSupplier(SupplierDTO supplier);
}
