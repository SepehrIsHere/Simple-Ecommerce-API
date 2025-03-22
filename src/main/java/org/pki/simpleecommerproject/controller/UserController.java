package org.pki.simpleecommerproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.pki.simpleecommerproject.dto.UserDTO;
import org.pki.simpleecommerproject.entities.User;
import org.pki.simpleecommerproject.service.UserService;
import org.pki.simpleecommerproject.util.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "User API Controller", description = "A simple controller for user operation")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/save")
    @Operation(summary = "saving user", description = "saves a user to repository")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
        try {
            User user = userMapper.convertToEntity(userDTO);
            return ResponseEntity.ok(userService.save(user));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @PatchMapping("/update")
    @Operation(summary = "updates user", description = "updates the user in repository")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(userService.update(userMapper.convertToEntity(userDTO)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @GetMapping("/find-by-id")
    @Operation(summary = "finds user based on id", description = "returns user based on id if exists")
    public ResponseEntity<UserDTO> findById(@RequestBody Long userId) {
        try {
            return ResponseEntity.ok(userMapper.convertToDTO(userService.findById(userId).get()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @GetMapping("/find-by-name")
    @Operation(summary = "finds user based on name", description = "finds user using firstname and lastname")
    public ResponseEntity<UserDTO> findByName(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(userMapper.convertToDTO(userService.findByFirstNameAndLastName(userDTO.getFirstName(), userDTO.getLastName()).get()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @GetMapping("/find-by-email")
    @Operation(summary = "finds user by email", description = "finds user using email")
    public ResponseEntity<UserDTO> findByEmail(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(userMapper.convertToDTO(userService.findByEmail(userDTO.getEmail()).get()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @DeleteMapping("/delete")
    @Operation(summary = "deletes user", description = "deletes user using user objects")
    public ResponseEntity<String> delete(@RequestBody UserDTO userDTO) {
        try {
            Optional<User> user = userService.findById(userDTO.getId());
            userService.delete(user.get());
            return ResponseEntity.ok("Delete object succesfully");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @DeleteMapping("/delete-by-id")
    @Operation(summary = "deletes user", description = "deletes user by id")
    public ResponseEntity<String> deleteById(@RequestBody UserDTO userDTO) {
        try {
            Optional<User> user = userService.findById(userDTO.getId());
            userService.deleteById(user.get().getId());
            return ResponseEntity.ok("Delete object succesfully");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @GetMapping("/find-all")
    @Operation(summary = "finds all users", description = "finds all user objects in repository")
    public ResponseEntity<List<UserDTO>> findAll() {
        try {
            return ResponseEntity.ok(userService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }
}
