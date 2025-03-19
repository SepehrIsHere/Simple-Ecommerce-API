package org.pki.simpleecommerproject.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class ValidationUtil {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public Set<ConstraintViolation<Object>> validate(Object object) {
        return validator.validate(object);
    }

    public boolean isValid(Set<ConstraintViolation<Object>> violations) {
        return violations.isEmpty();
    }

    public void validateAndThrow(Object object) {
        Set<ConstraintViolation<Object>> violations = validate(object);
        if (isValid(violations)) {
            StringBuilder msg = new StringBuilder("Validation Failed : ");
            for (ConstraintViolation<Object> violation : violations) {
                msg.append(violation.getMessage()).append(";");
            }
        }
    }
}
