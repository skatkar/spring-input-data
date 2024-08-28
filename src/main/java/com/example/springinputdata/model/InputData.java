package com.example.springinputdata.model;

import com.example.springinputdata.util.DataProducer;
import com.example.springinputdata.util.WorkFlowStage;
import com.example.springinputdata.util.annotation.ValidFieldType;
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

    @ValidFieldType(enumClass = WorkFlowStage.class, message = "Invalid workflow stage")
    private String workflowStage;

    @ValidFieldType(enumClass = DataProducer.class, message = "Invalid data producer stage")
    private String dataProducer;
}
