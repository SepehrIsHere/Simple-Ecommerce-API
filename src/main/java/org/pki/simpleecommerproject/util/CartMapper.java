package org.pki.simpleecommerproject.util;

import lombok.RequiredArgsConstructor;
import org.pki.simpleecommerproject.dto.CartDTO;
import org.pki.simpleecommerproject.entities.Cart;
import org.pki.simpleecommerproject.entities.User;
import org.pki.simpleecommerproject.exception.FailedToMapException;
import org.pki.simpleecommerproject.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CartMapper {
    private final UserService userService;

    public Cart convertToEntity(CartDTO dto) {
        Cart cart = new Cart();
        Optional<User> user = userService.findById(dto.getUserId());
        if (dto.getId() != null) cart.setId(dto.getId());
        if (dto.getUID() != null) cart.setUID(dto.getUID());
        if (dto.getName() != null) cart.setName(dto.getName());
        if (dto.getUserId() != null && user.isPresent()) cart.setUser(user.get());
        if (cart != null) return cart;
        else throw new FailedToMapException("Failed to map dto to cart");
    }

    public CartDTO convertToDto(Cart cart) {
        CartDTO dto = new CartDTO();
        if (cart.getId() != null) dto.setId(cart.getId());
        if (cart.getUID() != null) dto.setUID(cart.getUID());
        if (cart.getName() != null) dto.setName(cart.getName());
        if (cart.getUser() != null && cart.getUser().getId() != null) dto.setUserId(cart.getUser().getId());
        if (dto != null) return dto;
        else throw new FailedToMapException("Failed to map cart to dto");
    }
}
