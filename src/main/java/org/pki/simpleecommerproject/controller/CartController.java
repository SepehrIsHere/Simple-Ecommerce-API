package org.pki.simpleecommerproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.pki.simpleecommerproject.dto.CartDTO;
import org.pki.simpleecommerproject.entities.Cart;
import org.pki.simpleecommerproject.service.CartService;
import org.pki.simpleecommerproject.util.CartMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
@Tag(name = "Cart Controller", description = "Simple Controller for cart operations")
public class CartController {
    private final CartService cartService;
    private final CartMapper cartMapper;

    @PostMapping("/save")
    @Operation(summary = "saves a cart", description = "saves a given cart to repository")
    public ResponseEntity<CartDTO> save(@RequestBody CartDTO cartDTO) {
        try {
            Cart cart = cartMapper.convertToEntity(cartDTO);
            return ResponseEntity.ok(cartService.save(cart));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @PatchMapping("/update")
    @Operation(summary = "updates a cart", description = "updates a given cart in repository")
    public ResponseEntity<CartDTO> update(@RequestBody CartDTO cartDTO) {
        try {
            Cart cart = cartMapper.convertToEntity(cartDTO);
            return ResponseEntity.ok(cartService.save(cart));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @DeleteMapping("/delete")
    @Operation(summary = "deletes a cart", description = "deletes a given cart object")
    public ResponseEntity<String> delete(@RequestBody Cart cart) {
        try {
            cartService.delete(cart);
            return ResponseEntity.ok("Cart deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @DeleteMapping("/delete-by-id")
    @Operation(summary = "deletes a cart", description = "deletes a cart using id")
    public ResponseEntity<String> deleteById(@RequestBody CartDTO cartDTO) {
        try {
            cartService.deleteById(cartDTO.getId());
            return ResponseEntity.ok("Cart deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }
}
