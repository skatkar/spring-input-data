package com.example.springinputdata.util;

public enum DataProducer {

    KAFKA_PRODUCER("KafkaProducer");

    private String label;

    DataProducer(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
