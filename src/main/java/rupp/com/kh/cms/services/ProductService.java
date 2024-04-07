package rupp.com.kh.cms.services;

import java.util.List;

import rupp.com.kh.cms.dto.ProductDTO;

public interface ProductService {

    void deleteProduct(Long id);
    void updateProduct(Long id);
    ProductDTO retrieveProduct(Long id);
    List<ProductDTO> retrieveAllProduct();
    void createProduct(ProductDTO product);
    void updateProduct(ProductDTO product);
    
}
