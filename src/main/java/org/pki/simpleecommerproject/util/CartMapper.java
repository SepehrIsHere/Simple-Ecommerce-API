package org.pki.simpleecommerproject.util;

import org.pki.simpleecommerproject.dto.CartDTO;
import org.pki.simpleecommerproject.entities.Cart;
import org.pki.simpleecommerproject.exception.FailedToMapException;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    public Cart convertToEntity(CartDTO dto){
        Cart cart = new Cart();
        if(dto.getId() != null) cart.setId(dto.getId());
        if(dto.getUID() != null) cart.setUID(dto.getUID());
        if(dto.getName() != null) cart.setName(dto.getName());
        if(cart != null) return cart; else throw new FailedToMapException("Failed to map dto to cart");
    }

    public CartDTO convertToDto(Cart cart){
        CartDTO dto = new CartDTO();
        if(cart.getId() != null) dto.setId(cart.getId());
        if(cart.getUID() != null) dto.setUID(cart.getUID());
        if(cart.getName() != null) dto.setName(cart.getName());
        if(dto != null) return dto; else throw new FailedToMapException("Failed to map cart to dto");
    }
}
