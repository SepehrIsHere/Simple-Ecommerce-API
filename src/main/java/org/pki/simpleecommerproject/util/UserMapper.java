package org.pki.simpleecommerproject.util;

import org.pki.simpleecommerproject.dto.UserDTO;
import org.pki.simpleecommerproject.entities.User;
import org.pki.simpleecommerproject.exception.FailedToMapException;
import org.pki.simpleecommerproject.exception.FieldIsNullException;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User convertToEntity(UserDTO userDTO) {
        User user = new User();
        if (userDTO.getId() != null) user.setId(userDTO.getId());
        else throw new FieldIsNullException("id is null");
        if (userDTO.getFirstName() != null) user.setFirstName(userDTO.getFirstName());
        else throw new FieldIsNullException("First name is null");
        if (userDTO.getLastName() != null) user.setLastName(userDTO.getLastName());
        else throw new FieldIsNullException("Last name is null");
        if (userDTO.getEmail() != null) user.setEmail(userDTO.getEmail());
        else throw new FieldIsNullException("Email is null");
        if (userDTO.getPassword() != null) user.setPassword(userDTO.getPassword());
        else throw new FieldIsNullException("Password is null");
        if (user != null) return user;
        else throw new FailedToMapException("Failed to convert UserDTO to User");
    }

    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        if (user.getId() != null) userDTO.setId(user.getId());
        else throw new FieldIsNullException("id is null");
        if (user.getFirstName() != null) userDTO.setFirstName(user.getFirstName());
        else throw new FieldIsNullException("First name is null");
        if (user.getLastName() != null) userDTO.setLastName(user.getLastName());
        else throw new FieldIsNullException("Last name is null");
        if (user.getEmail() != null) userDTO.setEmail(user.getEmail());
        else throw new FieldIsNullException("Email is null");
        if (user.getPassword() != null) userDTO.setPassword(user.getPassword());
        else throw new FieldIsNullException("Password is null");
        if (userDTO != null) return userDTO;
        else throw new FailedToMapException("Failed to convert User to UserDTO");
    }

}
