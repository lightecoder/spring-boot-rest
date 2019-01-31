package com.ray.parker.controller;

import com.ray.parker.dao.DocumentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentControllerTest {

    @Autowired
    private DocumentRepository documentRepository;

   // @MockBean
   // private DocumentRepository documentRepository;

    @Test
    public void redirectToList() {
    }

    @Test
    public void listDocuments() {
    }

    @Test
    public void getDocument() {
    }

    @Test
    public void edit() {
    }

    @Test
    public void newDocument() {
    }

    @Test
    public void saveOrUpdateDocument() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void saveDocumentsFromEndpoint() {
    }
}