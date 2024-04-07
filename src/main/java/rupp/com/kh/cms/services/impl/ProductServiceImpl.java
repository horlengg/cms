package rupp.com.kh.cms.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rupp.com.kh.cms.dto.ProductDTO;
import rupp.com.kh.cms.entities.ProductEntity;
import rupp.com.kh.cms.repositories.ProductRepository;
import rupp.com.kh.cms.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired ProductRepository productRepository;
    
    @Override
    public void deleteProduct(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    @Override
    public void updateProduct(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }


    @Override
    public void createProduct(ProductDTO product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProduct'");
    }

    @Override
    public void updateProduct(ProductDTO product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public ProductDTO retrieveProduct(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'retrieveProduct'");
    }

    @Override
    public List<ProductDTO> retrieveAllProduct() {
        List<ProductDTO> productDTOs = new ArrayList<>();
        List<ProductEntity> productEntities = productRepository.findAll();

        for(ProductEntity pro : productEntities) {
            String createdBy = null;
            String updatedBy = null;
            if(pro.getCreatedBy() != null) 
                createdBy = pro.getCreatedBy().getFullName();
            if(pro.getUpdatedBy() != null) 
                updatedBy = pro.getUpdatedBy().getFullName();
            productDTOs.add(
                new ProductDTO(
                    pro.getId(),
                    pro.getBarcode(),
                    pro.getName(),
                    pro.getUnitPrice(),
                    pro.getQty(),
                    pro.getCategory().getName(),
                    pro.getSupplier().getName(),
                    pro.getDescription(),
                    pro.getCreatedAt(),
                    pro.getUpdatedAt(),
                    createdBy,
                    updatedBy
                )
            );
        }

        return productDTOs;
    }
    
}
