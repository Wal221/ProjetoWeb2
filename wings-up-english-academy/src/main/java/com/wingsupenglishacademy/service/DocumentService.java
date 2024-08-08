package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.model.Document;
import com.wingsupenglishacademy.repository.DocumentRepository;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
    public Document upload(MultipartFile file) throws IOException {
        if (!file.getContentType().equals("application/pdf")) {
            throw new RuntimeException("Invalid file type. Only PDF files are allowed.");
        }
        Document document = new Document();
        document.setName(file.getOriginalFilename());
        document.setData(file.getBytes());
        document.setCreatedAt(LocalDateTime.now());
        return documentRepository.save(document);
    }


    public ResponseEntity<ByteArrayResource> download(Long id) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        HttpHeaders headers = new HttpHeaders();

        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + document.getName());
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
        headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(document.getData().length));

        return ResponseEntity.ok()
                .headers(headers)
                .body(new ByteArrayResource(document.getData()));
    }
}
