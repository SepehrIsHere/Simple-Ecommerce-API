package org.pki.simpleecommerproject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Product extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    private Double price;

    private String description;

    private Integer quantity;

    private boolean available;

    @ManyToMany
    private Set<Cart> cart;

    @Override
    protected void onCreate() {
        super.onCreate();
        available = quantity != null && quantity > 0;
    }
}
