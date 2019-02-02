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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (id != null ? !id.equals(document.id) : document.id != null) return false;
        if (hash != null ? !hash.equals(document.hash) : document.hash != null) return false;
        if (description != null ? !description.equals(document.description) : document.description != null)
            return false;
        if (format != null ? !format.equals(document.format) : document.format != null) return false;
        if (url != null ? !url.equals(document.url) : document.url != null) return false;
        if (title != null ? !title.equals(document.title) : document.title != null) return false;
        if (documentOf != null ? !documentOf.equals(document.documentOf) : document.documentOf != null) return false;
        if (datePublished != null ? !datePublished.equals(document.datePublished) : document.datePublished != null)
            return false;
        if (dateModified != null ? !dateModified.equals(document.dateModified) : document.dateModified != null)
            return false;
        if (documentType != null ? !documentType.equals(document.documentType) : document.documentType != null)
            return false;
        return relatedItem != null ? relatedItem.equals(document.relatedItem) : document.relatedItem == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hash != null ? hash.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (documentOf != null ? documentOf.hashCode() : 0);
        result = 31 * result + (datePublished != null ? datePublished.hashCode() : 0);
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        result = 31 * result + (documentType != null ? documentType.hashCode() : 0);
        result = 31 * result + (relatedItem != null ? relatedItem.hashCode() : 0);
        return result;
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
