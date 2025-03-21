package org.pki.simpleecommerproject.repository;

import org.pki.simpleecommerproject.entities.Cart;
import org.pki.simpleecommerproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c WHERE c.name = :name")
    Optional<Cart> findByName(@Param("name") String name);

    @Query("SELECT c FROM Cart c WHERE c.user = :user")
    Optional<Cart> findByUser(@Param("user") User user);

    @Query("SELECT c FROM Cart c WHERE c.UID = :UID")
    Optional<Cart> findByUID(@Param("UID") String UID);

}
