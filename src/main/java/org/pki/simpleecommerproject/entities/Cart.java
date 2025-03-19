package org.pki.simpleecommerproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart extends BaseEntity {

    private String name;

    private String UID;

    @OneToOne
    private User user;

    @OneToMany
    private List<Product> products;

}
