package org.pki.simpleecommerproject.service;

import org.pki.simpleecommerproject.dto.CartDTO;
import org.pki.simpleecommerproject.dto.ProductDTO;
import org.pki.simpleecommerproject.entities.Cart;

import java.util.Optional;

public interface CartService {
    CartDTO save(Cart cart);

    CartDTO update(Cart cart);

    void delete(Cart cart);

    void deleteById(Long id);

    Optional<Cart> findById(Long id);

    Optional<Cart> findByUserId(Long userId);

    Optional<Cart> findByName(String name);

    Optional<Cart> findByUID(String UID);

    String addToCart(ProductDTO productDTO, Long cartId);
}
