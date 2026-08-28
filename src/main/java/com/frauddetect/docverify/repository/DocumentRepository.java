// src/main/java/com/frauddetect/docverify/repository/DocumentRepository.java

package com.frauddetect.docverify.repository;

import com.frauddetect.docverify.model.entity.Document;
import com.frauddetect.docverify.model.entity.DocumentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    Optional<Document> findBySha256Hash(String sha256Hash);

    List<Document> findByUserId(Long userId);

    List<Document> findByStatus(DocumentStatus status);

    boolean existsBySha256Hash(String sha256Hash);
}