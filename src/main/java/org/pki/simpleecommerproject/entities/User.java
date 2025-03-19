package org.pki.simpleecommerproject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "Users")
public class User extends BaseEntity {

    @Column(unique = true, nullable = false)
    @NotBlank(message = "first name can't be blank or null")
    private String firstName;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "last name can't be blank or null")
    private String lastName;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "email cant be blank or null")
    @Email(message = "email is invalid")
    private String email;

    @NotBlank(message = "password cant be blank or null")
    private String password;

}
