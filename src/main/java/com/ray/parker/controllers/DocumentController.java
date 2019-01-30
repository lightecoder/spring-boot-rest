package com.ray.parker.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ray.parker.domain.DataWrapper;
import com.ray.parker.domain.Document;
import com.ray.parker.repositories.DocumentRepository;
import com.ray.parker.utils.OkHttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ray Parker on 25/01/18.
 */
@Controller
public class DocumentController implements WebMvcConfigurer {
    private final static Logger LOGGER = LoggerFactory.getLogger(DocumentController.class);
    private DocumentRepository documentRepository;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/document/list").setViewName("list");
    }

    @Autowired
    public void setDocumentRepository(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @GetMapping("/")
    public String redirectToList() {
        return "redirect:/document/list";
    }

    @GetMapping({"/document/list", "/document"})
    public String listDocuments(Model model) {
        List<Document> documents = new ArrayList<>();
        documentRepository.findAll().forEach(documents::add);
        model.addAttribute("documents", documents);
        return "document/list";
    }

    @GetMapping("/document/show/{id}")
    public String getDocument(@PathVariable String id, Model model) {
        model.addAttribute("document", documentRepository.findById(id).orElse(null));
        return "document/show";
    }

    @GetMapping("document/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        Document document = documentRepository.findById(id).orElse(null);
        model.addAttribute("document", document);
        return "document/documentform";
    }

    @GetMapping("/document/new")
    public String newDocument(Model model) {
        model.addAttribute("document", new Document()); // -> th:object="${document} in html page
        return "document/documentform";
    }

    @PostMapping("/document")
    public String saveOrUpdateDocument(@Valid Document document, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "document/documentform";
        }
        Document savedDocument =  documentRepository.save(document);
        return "redirect:/document/show/" + savedDocument.getId();
    }

    @RequestMapping("/document/delete/{id}")
    public String delete(@PathVariable String id) {
        documentRepository.deleteById(id);
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
            documentRepository.saveAll(documents);
            LOGGER.info("Data from endpoint was successfully saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Document> documents = new ArrayList<>();
        documentRepository.findAll().forEach(documents::add);
        model.addAttribute("documents", documents);
        return "document/list";
    }
}
