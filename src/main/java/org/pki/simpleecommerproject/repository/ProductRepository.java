package org.pki.simpleecommerproject.repository;

import org.pki.simpleecommerproject.entities.Cart;
import org.pki.simpleecommerproject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    Optional<Product> findByName(@Param("name") String name);

    @Query("SELECT p FROM Product p WHERE p.cart = :cart")
    Optional<List<Product>> findItemsByCart(@Param("cart") Cart cart);
}
