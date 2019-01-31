package com.ray.parker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DataWrapper {

    public List<Document> documents;

    public DataWrapper() {
    }
    @JsonProperty("data")
    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
