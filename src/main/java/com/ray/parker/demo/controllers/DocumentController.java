package com.ray.parker.demo.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ray.parker.demo.commands.DocumentForm;
import com.ray.parker.demo.converters.DocumentToDocumentForm;
import com.ray.parker.demo.domain.DataWrapper;
import com.ray.parker.demo.domain.Document;
import com.ray.parker.demo.services.DocumentService;
import com.ray.parker.demo.utils.OkHttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


/**
 * Created by Ray Parker on 25/01/18.
 */
@Controller
public class DocumentController {
    private final static Logger LOGGER = LoggerFactory.getLogger(DocumentController.class);
    private DocumentService documentService;
    private DocumentToDocumentForm documentToDocumentForm;

    @Autowired
    public void setDocumentToDocumentForm(DocumentToDocumentForm documentToDocumentForm) {
        this.documentToDocumentForm = documentToDocumentForm;
    }

    @Autowired
    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping("/")
    public String redirToList() {
        return "redirect:/document/list";
    }

    @RequestMapping({"/document/list", "/document"})
    public String listDocuments(Model model) {
        model.addAttribute("documents", documentService.listAll());
        return "document/list";
    }

    @RequestMapping("/document/show/{id}")
    public String getDocument(@PathVariable String id, Model model) {
        model.addAttribute("document", documentService.getById(id));
        return "document/show";
    }

    @RequestMapping("document/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        Document document = documentService.getById(id);
        DocumentForm documentForm = documentToDocumentForm.convert(document);
        model.addAttribute("documentForm", documentForm);
        return "document/documentform";
    }

    @RequestMapping("/document/new")
    public String newDocument(Model model) {
        model.addAttribute("documentForm", new DocumentForm());
        return "document/documentform";
    }

    @RequestMapping(value = "/document", method = RequestMethod.POST)
    public String saveOrUpdateDocument(@Valid DocumentForm documentForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "document/documentform";
        }
        Document savedDocument = documentService.saveOrUpdateDocumentForm(documentForm);
        return "redirect:/document/show/" + savedDocument.getId();
    }

    @RequestMapping("/document/delete/{id}")
    public String delete(@PathVariable String id) {
        documentService.delete(id);
        return "redirect:/document/list";
    }

    @RequestMapping("/document/fromEndPoint")
    public String saveDocumentsFromEndpoint(Model model) {
        // get json data from response
        try {
            OkHttpService okhttpService = new OkHttpService();
            String stringData = okhttpService.getResponseData("https://lb-api-sandbox.prozorro.gov.ua/api/2.4/" +
                    "contracts/4805f381d48948b1b34d6ea2daa029a3/documents");
            ObjectMapper objectMapper = new ObjectMapper();
            final DataWrapper data = objectMapper.readValue(stringData, DataWrapper.class);
            List<Document> documents = data.getDocuments();
            documentService.saveAll(documents);
            LOGGER.info("Data from endpoint was successfully saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("documents", documentService.listAll());
        return "document/list";
    }
}
