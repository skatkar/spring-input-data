package com.example.springinputdata.util;

public enum WorkFlowStage {

    HYDRATION("Hydration"),
    TRANSFORMATION("Transformation");

    private String label;
    WorkFlowStage(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
