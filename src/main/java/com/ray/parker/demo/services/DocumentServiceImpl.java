package com.ray.parker.demo.services;

import com.ray.parker.demo.commands.DocumentForm;
import com.ray.parker.demo.converters.DocumentFormToDocument;
import com.ray.parker.demo.domain.Document;
import com.ray.parker.demo.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RP on 25/01/18.
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    private DocumentRepository documentRepository;
    private DocumentFormToDocument documentFormToDocument;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository, DocumentFormToDocument documentFormToDocument) {
        this.documentRepository = documentRepository;
        this.documentFormToDocument = documentFormToDocument;
    }


    @Override
    public List<Document> listAll() {
        List<Document> documents = new ArrayList<>();
        documentRepository.findAll().forEach(documents::add);
        return documents;
    }

    @Override
    public Document getById(String id) {
        return documentRepository.findById(id).orElse(null);
    }

    @Override
    public Document saveOrUpdate(Document document) {
        documentRepository.save(document);
        return document;
    }

    @Override
    public void delete(String  id) {
        documentRepository.deleteById(id);

    }

    @Override
    public void saveAll(List<Document> documents) {
        documentRepository.saveAll(documents);
    }

    @Override
    public Document saveOrUpdateDocumentForm(DocumentForm documentForm) {
        Document savedDocument = saveOrUpdate(documentFormToDocument.convert(documentForm));

        System.out.println("Saved Document Id: " + savedDocument.getId());
        return savedDocument;
    }
}
