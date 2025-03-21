package org.pki.simpleecommerproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.pki.simpleecommerproject.dto.UserDTO;
import org.pki.simpleecommerproject.entities.User;
import org.pki.simpleecommerproject.exception.UserNotFoundException;
import org.pki.simpleecommerproject.exception.UserOperationException;
import org.pki.simpleecommerproject.repository.UserRepository;
import org.pki.simpleecommerproject.service.UserService;
import org.pki.simpleecommerproject.util.UserMapper;
import org.pki.simpleecommerproject.util.ValidationUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;
    private final UserMapper userMapper;

    @Override
    public UserDTO save(User user) {
        try {
            if (validationUtil.isValid(user)) {
                return userMapper.convertToDTO(userRepository.save(user));
            } else {
                throw new UserOperationException(validationUtil.validateAndThrow(user));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public UserDTO update(User user) {
        try {
            return userMapper.convertToDTO(userRepository.save(user));
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public Optional<User> login(String email, String password) {
        try {
            return Optional.ofNullable(userRepository.login(email, password).orElseThrow(() -> new UserNotFoundException("User with email :" + email + " not found")));
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
            return Optional.ofNullable(userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User with email :" + email + " not found")));
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public Optional<User> findByFirstNameAndLastName(String firstName, String lastName) {
        try {
            return Optional.ofNullable(userRepository.findByFirstNameAndLastName(firstName, lastName).orElseThrow(() -> new UserNotFoundException("User not found with first namme :" + firstName + " and last name :" + " last name")));
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        try {
            return Optional.of(userRepository.findById(id)).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public List<UserDTO> findAll() {
        try {
            List<User> users = userRepository.findAll();
            List<UserDTO> dtos = new ArrayList<>();
            for (User user : users) {
                dtos.add(userMapper.convertToDTO(user));
            }
            return dtos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(User user) {
        try {
            userRepository.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }
}
