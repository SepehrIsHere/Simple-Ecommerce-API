package org.pki.simpleecommerproject.service;

import org.pki.simpleecommerproject.dto.UserDTO;
import org.pki.simpleecommerproject.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO save(User user);

    UserDTO update(User user);

    Optional<User> login(String email, String password);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);

    void deleteById(Long id);

    void delete(User user);

    List<UserDTO> findAll();
}
