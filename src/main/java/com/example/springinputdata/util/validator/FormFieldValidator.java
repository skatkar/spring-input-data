package com.example.springinputdata.util.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Predicate;

public class FormFieldValidator implements ConstraintValidator<ValidateField, String> {
    private FormField formField;

    Map<FormField, Predicate<String>> mapper;

    @Override
    public void initialize(ValidateField constraintAnnotation) {
        this.formField = constraintAnnotation.fieldName();
        this.mapper = loadPredicatemap();
    }

    private Map<FormField, Predicate<String>> loadPredicatemap() {
        Predicate<String> methods = field -> Arrays.stream(HttpMethod.values())
                .map(Enum::name)
                .anyMatch(field::equals);

        Predicate<String> fields = StringUtils::isNotBlank;

        mapper = new EnumMap<>(FormField.class);
        mapper.put(FormField.HTTP_METHODS, methods);
        mapper.put(FormField.FILTER_FIELDS, fields);
        return mapper;
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return mapper.get(formField).test(field);
    }
}
