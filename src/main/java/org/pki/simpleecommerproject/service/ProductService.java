package org.pki.simpleecommerproject.service;

import org.pki.simpleecommerproject.dto.ProductDTO;
import org.pki.simpleecommerproject.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductDTO save(Product product);

    ProductDTO update(Product product);

    Optional<Product> findByName(String name);

    Optional<List<Product>> findByCart(Long cartId);

    Optional<Product> findById(Long id);

    Optional<List<Product>> findAll();

    void delete(Product product);

    void deleteById(long id);

}
