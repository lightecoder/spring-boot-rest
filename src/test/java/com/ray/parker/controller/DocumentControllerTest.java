package com.ray.parker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ray.parker.model.DataWrapper;
import com.ray.parker.model.Document;
import com.ray.parker.services.DocumentService;
import com.ray.parker.utils.OkHttpService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentControllerTest {

    @Autowired
    private DocumentController documentController;
    @MockBean
    private DocumentService documentService;
    @MockBean
    private Model model;
    @MockBean
    private Document document;
    @MockBean
    private BindingResult bindingResult;
    @MockBean
    private OkHttpService okhttpService;
    private  String stringData;

    @Before
    public void setUp() {
       stringData = "{\"data\": [{\"hash\": \"md5:232dba893a22ac722249ad92f8bccf22\", \"format\": \"text/plain\"," +
                " \"url\": \"https://public-docs-sandbox.prozorro.gov.ua/get/3500487074064bd98f1076c21fe69e9a?KeyID=1331dc52" +
                "&Signature=w%252BTQLJCiU%2FDQXfp%2FxB0VfDNRzImPv7zch3e8H1jfVOZrDJZuam%2FOTVLlvpdUiz9WVLHdUzdMrQJclbl4Vs28C" +
                "Q%253D%253D\", \"title\": \"11.09.2018.xlsx\", \"documentOf\": \"tender\", \"datePublished\": \"2018-09-19T1" +
                "3:12:21.136232+03:00\", \"documentType\": \"subContract\", \"dateModified\": \"2018-09-19T13:12:21.136263+03:" +
                "00\", \"id\": \"4f6d6dc59d1844bb80143ccc2e727a2f\"}]}";
    }

    @Test
    public void redirectToList() {
        assertEquals("redirect:/document/list", documentController.redirectToList());
    }

    @Test
    public void listDocuments() {
        assertEquals("document/list", documentController.listDocuments(model));
    }

    @Test
    public void getDocument() {
        assertEquals("document/show", documentController.getDocument("", model));
    }

    @Test
    public void edit() {
        assertEquals("document/documentform", documentController.edit("", model));
    }

    @Test
    public void newDocument() {
        assertEquals("document/documentform", documentController.newDocument(model));
    }

    @Test
    public void saveOrUpdateDocumentSuccess() {
        when(documentService.saveOrUpdate(document)).thenReturn(document);
        assertEquals("redirect:/document/show/" + document.getId(),
                documentController.saveOrUpdateDocument(document, bindingResult));
    }

    @Test
    public void saveOrUpdateDocumentFail() {
        when(bindingResult.hasErrors()).thenReturn(true);
        assertEquals("document/documentform",
                documentController.saveOrUpdateDocument(document, bindingResult));
    }

    @Test
    public void delete() {
        assertEquals("redirect:/document/list", documentController.delete(""));
    }

    @Test
    public void saveDocumentsFromEndpointReturnPage() throws IOException {
        when(okhttpService.getResponseData(any(String.class))).thenReturn(stringData);
        assertEquals("document/list", documentController.saveDocumentsFromEndpoint(model));

    }

    @Test(expected = IOException.class)
    public void saveDocumentsFromEndpointThrowsIOException() throws IOException {
        when(okhttpService.getResponseData(any(String.class))).thenThrow(IOException.class);
        documentController.saveDocumentsFromEndpoint(model);
    }

    @Test
    public void saveDocumentsFromEndpointSuccessExecutesSaveAllAndListAllMethod() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        DataWrapper data = objectMapper.readValue(stringData, DataWrapper.class);
        List<Document> documents = data.getDocuments();
        when(okhttpService.getResponseData(any(String.class))).thenReturn(stringData);
        documentController.saveDocumentsFromEndpoint(model);
        verify(documentService, times(1)).saveAll(documents);
        verify(documentService, times(1)).listAll();
    }
}