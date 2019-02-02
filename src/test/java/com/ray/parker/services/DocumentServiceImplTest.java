package com.ray.parker.services;

import com.ray.parker.dao.DocumentRepository;
import com.ray.parker.model.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentServiceImplTest {

    @Autowired
    private DocumentService documentService;
    @MockBean
    private Document document;
    @MockBean
    private DocumentRepository documentRepository;

    @Test
    public void listAllSuccess() {
        List<Document> documents = new ArrayList<>();
        documents.add(new Document());
        documents.add(new Document());
        when(documentRepository.findAll()).thenReturn(Stream
                .of(new Document(), new Document()).collect(Collectors.toList()));
        assertEquals(documents, documentService.listAll());
    }

    @Test
    public void getByIdSuccess() {
        String id = "1";
        when(documentRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(document));
        assertEquals(document, documentService.getById(id));
    }

    @Test
    public void getByIdSuccessFail() {
        String id = "1";
        assertNull(documentService.getById(id));
    }

    @Test
    public void saveOrUpdate() {
        Document document = new Document();
        document.setId("1");
        when(documentRepository.save(document)).thenReturn(document);
        assertEquals(document, documentService.saveOrUpdate(document));
    }

    @Test
    public void delete() {
        Document document = new Document();
        document.setId("1");
        documentService.delete(document.getId());
        verify(documentRepository, times(1)).deleteById(document.getId());
    }

    @Test
    public void saveAll() {
        List<Document> documents = new ArrayList<>();
        documents.add(new Document());
        documentService.saveAll(documents);
        verify(documentRepository, times(1)).saveAll(documents);
    }
}