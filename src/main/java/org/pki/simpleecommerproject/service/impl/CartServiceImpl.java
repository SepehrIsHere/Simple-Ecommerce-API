package org.pki.simpleecommerproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.pki.simpleecommerproject.dto.CartDTO;
import org.pki.simpleecommerproject.dto.ProductDTO;
import org.pki.simpleecommerproject.entities.Cart;
import org.pki.simpleecommerproject.entities.Product;
import org.pki.simpleecommerproject.entities.User;
import org.pki.simpleecommerproject.exception.CartNotFoundException;
import org.pki.simpleecommerproject.exception.CartOperationException;
import org.pki.simpleecommerproject.exception.InvalidFieldException;
import org.pki.simpleecommerproject.exception.ProductNotFoundException;
import org.pki.simpleecommerproject.repository.CartRepository;
import org.pki.simpleecommerproject.service.CartService;
import org.pki.simpleecommerproject.service.ProductService;
import org.pki.simpleecommerproject.service.UserService;
import org.pki.simpleecommerproject.util.CartMapper;
import org.pki.simpleecommerproject.util.ValidationUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ValidationUtil validationUtil;
    private final CartMapper cartMapper;
    private final UserService userService;
    private final ProductService productService;

    @Override
    public CartDTO save(Cart cart) {
        try {
            if (validationUtil.isValid(cart)) {
                return cartMapper.convertToDto(cartRepository.save(cart));
            } else {
                throw new InvalidFieldException(validationUtil.validateAndThrow(cart));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CartOperationException(e.getMessage());
        }
    }

    @Override
    public CartDTO update(Cart cart) {
        try {
            return cartMapper.convertToDto(cartRepository.save(cart));
        } catch (Exception e) {
            e.printStackTrace();
            throw new CartOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Cart cart) {
        try {
            cartRepository.delete(cart);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CartOperationException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            cartRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CartOperationException(e.getMessage());
        }
    }

    @Override
    public Optional<Cart> findById(Long id) {
        try {
            return Optional.of(cartRepository.findById(id)).orElseThrow(() -> new CartNotFoundException("Cart with id : " + id + " not found"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new CartOperationException(e.getMessage());
        }
    }

    @Override
    public Optional<Cart> findByUserId(Long userId) {
        try {
            Optional<User> user = userService.findById(userId);
            return Optional.of(cartRepository.findByUser(user.get())).orElseThrow(() -> new CartNotFoundException("Cart with id : " + userId + " not found"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new CartOperationException(e.getMessage());
        }
    }

    @Override
    public Optional<Cart> findByName(String name) {
        try {
            return Optional.of(cartRepository.findByName(name)).orElseThrow(() -> new CartNotFoundException("Cart with name : " + name + " not found"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new CartOperationException(e.getMessage());
        }
    }

    @Override
    public Optional<Cart> findByUID(String UID) {
        try {
            return Optional.of(cartRepository.findByUID(UID)).orElseThrow(() -> new CartNotFoundException("Cart with UID : " + UID + " not found"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new CartOperationException(e.getMessage());
        }
    }

    @Override
    public String addToCart(ProductDTO productDTO, Long cartId) {
        try {
            Product product = productService.findById(productDTO.getId()).orElseThrow(() -> new ProductNotFoundException(productDTO.getId() + " not found"));
            Optional<Cart> cart = findById(cartId);
            Optional<List<Product>> products = productService.findByCart(cartId);
            products.get().add(product);
            cart.get().setProducts(products.get());
            update(cart.get());
            return "product : " + productDTO.getName() + " added successfully";
        } catch (Exception e) {
            e.printStackTrace();
            throw new CartOperationException(e.getMessage());
        }
    }
}
