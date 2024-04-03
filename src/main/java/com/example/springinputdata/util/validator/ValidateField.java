package com.example.springinputdata.util.validator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FormFieldValidator.class)
@Documented
public @interface ValidateField {
    String message() default "{Custom validator -> " + "message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    FormField fieldName();

    @Target({CONSTRUCTOR, FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        ValidateField[] fieldName();
    }
}
