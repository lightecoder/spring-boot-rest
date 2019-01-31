package com.ray.parker.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by RP on 25/01/18.
 */
@Entity
@Table(schema = "json", name = "document")
public class Document {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) disabled due to reason -> we get from endpoint it's own id in String representation
    @NotEmpty(message = "The field is empty. Please provide id.")
    private String id;
    @NotEmpty(message = "The field is empty. Please provide hash.")
    @Size(min = 1, message = "Hash should have min 1 character.") // may cause exception in DB during reading json
    private String hash;
    @Size(max = 5, message = "Description should have max 5 characters.") // may cause exception in DB during reading json
    private String description;
    private String format;
    private String url;
    private String title;
    private String documentOf;
    private String datePublished;
    private String dateModified;
    private String documentType;
    private String relatedItem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDocumentOf() {
        return documentOf;
    }

    public void setDocumentOf(String documentOf) {
        this.documentOf = documentOf;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getRelatedItem() {
        return relatedItem;
    }

    public void setRelatedItem(String relatedItem) {
        this.relatedItem = relatedItem;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", hash='" + hash + '\'' +
                ", description='" + description + '\'' +
                ", format='" + format + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", documentOf='" + documentOf + '\'' +
                ", datePublished='" + datePublished + '\'' +
                ", dateModified='" + dateModified + '\'' +
                ", documentType='" + documentType + '\'' +
                ", relatedItem='" + relatedItem + '\'' +
                '}';
    }
}
