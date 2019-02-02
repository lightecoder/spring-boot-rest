package com.ray.parker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DataWrapper {

    private List<Document> documents;

    public DataWrapper() {
    }
    @JsonProperty("data")
    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataWrapper that = (DataWrapper) o;

        return documents != null ? documents.equals(that.documents) : that.documents == null;
    }

    @Override
    public int hashCode() {
        return documents != null ? documents.hashCode() : 0;
    }
}
