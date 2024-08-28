package com.example.springinputdata.util.validator;

import com.example.springinputdata.util.annotation.ValidFieldType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class FieldTypeValidator implements ConstraintValidator<ValidFieldType, String> {
    private Class<? extends Enum<?>> enumClass;


    @Override
    public void initialize(ValidFieldType constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null || value.isEmpty()){
            return false;
        }

        boolean isValid = Arrays.stream(enumClass.getEnumConstants())
                .anyMatch(e -> {
                   try{
                        String label = (String) enumClass.getMethod("getLabel").invoke(e);
                        return label.equals(value);
                   }catch(Exception exception) {
                       return false;
                   }
                });
        return isValid;
    }
}
