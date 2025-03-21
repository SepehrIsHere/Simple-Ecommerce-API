package org.pki.simpleecommerproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.pki.simpleecommerproject.dto.ProductDTO;
import org.pki.simpleecommerproject.entities.Cart;
import org.pki.simpleecommerproject.entities.Product;
import org.pki.simpleecommerproject.exception.InvalidFieldException;
import org.pki.simpleecommerproject.exception.ProductNotFoundException;
import org.pki.simpleecommerproject.exception.ProductOperationException;
import org.pki.simpleecommerproject.repository.ProductRepository;
import org.pki.simpleecommerproject.service.CartService;
import org.pki.simpleecommerproject.service.ProductService;
import org.pki.simpleecommerproject.util.ProductMapper;
import org.pki.simpleecommerproject.util.ValidationUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final CartService cartService;
    private final ProductRepository productRepository;
    private final ValidationUtil validationUtil;
    private final ProductMapper mapper;
    @Override
    public ProductDTO save(Product product) {
        try {
            if (validationUtil.isValid(product)) {
                return mapper.convertToDto(productRepository.save(product));
            } else {
                throw new InvalidFieldException(validationUtil.validateAndThrow(product));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProductOperationException(e.getMessage());
        }
    }

    @Override
    public ProductDTO update(Product product) {
        try {
            return mapper.convertToDto(productRepository.save(product));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProductOperationException(e.getMessage());
        }
    }

    @Override
    public Optional<Product> findByName(String name) {
        try {
            return Optional.ofNullable(productRepository.findByName(name).orElseThrow(() -> new ProductNotFoundException("product with name :" + name + " not found")));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProductOperationException(e.getMessage());
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        try{
            return Optional.ofNullable(productRepository.findById(id)).orElseThrow(() -> new ProductNotFoundException("product with id :" + id + " not found"));
        }catch (Exception e){
            e.printStackTrace();
            throw new ProductOperationException(e.getMessage());
        }
    }

    @Override
    public Optional<List<Product>> findByCart(Long cartId) {
        try {
            Optional<Cart> cart = cartService.findById(cartId);
            return Optional.ofNullable(productRepository.findProductsByCart(cart.get())).orElseThrow(() -> new ProductNotFoundException("product with id :" + cartId + " not found"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProductOperationException(e.getMessage());
        }
    }

    @Override
    public Optional<List<Product>> findAll() {
        try {
            return Optional.ofNullable(Optional.of(productRepository.findAll()).orElseThrow(() -> new ProductNotFoundException("No Products have been found")));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProductOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Product product) {
        try {
            productRepository.delete(product);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProductOperationException(e.getMessage());
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProductOperationException(e.getMessage());
        }
    }
}
