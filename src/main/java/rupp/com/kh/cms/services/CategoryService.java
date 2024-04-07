package rupp.com.kh.cms.services;


import java.util.List;

import rupp.com.kh.cms.dto.CategoryDTO;
import rupp.com.kh.cms.dto.request.CategoryRequestDTO;

public interface CategoryService {
    void deleteCategory(Long id);
    void updateCategory(CategoryDTO category,Long id);
    CategoryRequestDTO retrieveCategory(Long id);
    List<CategoryDTO> retrieveAllCategoey();
    void createCategory(CategoryDTO category);
}
