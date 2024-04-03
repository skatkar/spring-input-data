package com.example.springinputdata.model;

import com.example.springinputdata.util.validator.FormField;
import com.example.springinputdata.util.validator.ValidateField;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InputData {
    @ValidateField(fieldName = FormField.HTTP_METHODS, message = "Invalid method name")
    private String methods;

    @ValidateField(fieldName = FormField.FILTER_FIELDS, message = "Invalid fields. Please correct")
    private String fields;
}
