package org.pki.simpleecommerproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.pki.simpleecommerproject.dto.ProductDTO;
import org.pki.simpleecommerproject.entities.Product;
import org.pki.simpleecommerproject.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Tag(name = "Product Controller", description = "Controller class for product entity")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/save")
    @Operation(summary = "Saves product", description = "Saves the product entity")
    public ResponseEntity<ProductDTO> save(@RequestBody Product product) {
        try {
            return ResponseEntity.ok(productService.save(product));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @PatchMapping("/update")
    @Operation(summary = "Updates product", description = "updates the product if exists in db")
    public ResponseEntity<ProductDTO> update(@RequestBody Product product) {
        try {
            return ResponseEntity.ok(productService.save(product));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @DeleteMapping("/delete")
    @Operation(summary = "deletes product", description = "deletes product using product entity")
    public ResponseEntity<String> delete(@RequestBody Product product) {
        try {
            productService.delete(product);
            return ResponseEntity.ok("Deleted product" + "\n" + product.toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @DeleteMapping("/delete-by-id")
    @Operation(summary = "deletes product", description = "deletes product using product id")
    public ResponseEntity<String> deleteById(@RequestBody ProductDTO product) {
        try {
            productService.deleteById(product.getId());
            return ResponseEntity.ok("Deleted product" + "\n" + product.toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @GetMapping("/find-all")
    @Operation(summary = "finds all products", description = "finds all products")
    public ResponseEntity<List<Product>> findAll() {
        try {
            return ResponseEntity.ok(productService.findAll().get());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }
}
