package rupp.com.kh.cms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rupp.com.kh.cms.repositories.CategoryRepository;
import rupp.com.kh.cms.repositories.EmployeeRepository;
import rupp.com.kh.cms.repositories.ProductRepository;
import rupp.com.kh.cms.repositories.SupplierRepository;
import rupp.com.kh.cms.repositories.UserRepository;
import rupp.com.kh.cms.services.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired ProductRepository productRepository;
    @Autowired EmployeeRepository employeeRepository;
    @Autowired UserRepository userRepository;
    @Autowired CategoryRepository categoryRepository;
    @Autowired SupplierRepository supplierRepository;

    @Override
    public Long retrieveTotalEmployees() {
        return employeeRepository.count();
    }

    @Override
    public Long retrieveTotalUsers() {
        return userRepository.count();
    }

    @Override
    public Long retrieveTotalSupplier() {
        return supplierRepository.count();
    }

    @Override
    public Long retrieveTotalProducts() {
        return productRepository.count();
    }

    @Override
    public Long retrieveTotalCategories() {
        return categoryRepository.count();
    }
    
}
