package org.pki.simpleecommerproject.util;

import org.pki.simpleecommerproject.dto.ProductDTO;
import org.pki.simpleecommerproject.entities.Product;
import org.pki.simpleecommerproject.exception.FailedToMapException;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product convertToEntity(ProductDTO dto) {
        Product product = new Product();
        if (dto.getName() != null) product.setName(dto.getName());
        if (dto.getPrice() != null) product.setPrice(dto.getPrice());
        if (dto.getId() != null) product.setId(dto.getId());
        if (dto.getQuantity() != null) product.setQuantity(dto.getQuantity());
        if(product != null) return product; else throw new FailedToMapException("Failed to convert ProductDTO to Product");
    }

    public ProductDTO convertToDto(Product product) {
        ProductDTO dto = new ProductDTO();
        if (product.getName() != null) dto.setName(product.getName());
        if (product.getPrice() != null) dto.setPrice(product.getPrice());
        if (product.getId() != null) dto.setId(product.getId());
        if (product.getQuantity() != null) dto.setQuantity(product.getQuantity());
        if(dto != null) return dto; else throw new FailedToMapException("Failed to convert Product to ProductDTO");
    }
}
