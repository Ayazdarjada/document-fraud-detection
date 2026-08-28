// src/main/java/com/frauddetect/docverify/repository/VerificationResultRepository.java

package com.frauddetect.docverify.repository;

import com.frauddetect.docverify.model.entity.VerificationResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerificationResultRepository
        extends JpaRepository<VerificationResult, Long> {

    List<VerificationResult> findByDocumentId(Long documentId);

    List<VerificationResult> findByCheckType(String checkType);
}