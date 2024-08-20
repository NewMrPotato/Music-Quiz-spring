package com.rather.UsingAI.ImageGeneration.Annotations;

import com.rather.UsingAI.ImageGeneration.SizeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SizeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSize {
    String message() default "Invalid value. This is not a valid size.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
