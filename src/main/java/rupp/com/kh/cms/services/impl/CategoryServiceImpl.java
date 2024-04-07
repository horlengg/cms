package rupp.com.kh.cms.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rupp.com.kh.cms.dto.CategoryDTO;
import rupp.com.kh.cms.dto.EmployeeDTO;
import rupp.com.kh.cms.dto.request.CategoryRequestDTO;
import rupp.com.kh.cms.entities.CategoryEntity;
import rupp.com.kh.cms.entities.EmployeeEntity;
import rupp.com.kh.cms.repositories.CategoryRepository;
import rupp.com.kh.cms.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{


    @Autowired CategoryRepository categoryRepository;

    @Override
    public void deleteCategory(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteCategory'");
    }

    @Override
    public void updateCategory(CategoryDTO category, Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'updateCategory'");
    }

    @Override
    public CategoryRequestDTO retrieveCategory(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'retrieveCategory'");
    }

    @Override
    public List<CategoryDTO> retrieveAllCategoey() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        List<CategoryDTO> response = new ArrayList<>();
        for(CategoryEntity cat : categories) {
            EmployeeEntity createdBy = cat.getCreatedBy();
            EmployeeEntity updatedBy = cat.getUpdatedBy();
            EmployeeDTO createdByRes = new EmployeeDTO();
            EmployeeDTO updatedByRes = new EmployeeDTO();
            if(createdBy != null) {
                createdByRes.setFullName(createdBy.getFullName());
                createdByRes.setEmpId(createdBy.getId());
            }
            if(updatedBy != null) {
                updatedByRes.setFullName(updatedBy.getFullName());
                updatedByRes.setEmpId(updatedBy.getId());
            }
            response.add(new CategoryDTO(
                cat.getId(),
                cat.getName(),
                cat.getDescription(),
                cat.getCreatedAt(),
                cat.getUpdatedAt(),
                createdByRes,
                updatedByRes
            ));
        }
        return response;
    }

    @Override
    public void createCategory(CategoryDTO category) {
        throw new UnsupportedOperationException("Unimplemented method 'createCategory'");
    }

    
}
