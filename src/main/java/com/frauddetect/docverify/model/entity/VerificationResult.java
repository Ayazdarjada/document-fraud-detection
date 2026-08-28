// src/main/java/com/frauddetect/docverify/model/entity/VerificationResult.java

package com.frauddetect.docverify.model.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "verification_results")
@Data
@NoArgsConstructor
public class VerificationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * The raw foreign-key value is kept explicitly because the project's
     * data model refers to this field as documentId.
     */
    @Column(name = "document_id", nullable = false)
    private Long documentId;

    /*
     * JPA relationship for referential integrity and future navigation.
     * The relationship is read-only so documentId remains the owning value.
     */
    @ManyToOne
    @JoinColumn(
            name = "document_id",
            insertable = false,
            updatable = false,
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_verification_result_document")
    )
    private Document document;

    @Column(nullable = false, length = 100)
    private String checkType;

    @Column(nullable = false, length = 50)
    private String checkResult;

    @Column(precision = 5, scale = 4)
    private BigDecimal confidenceScore;

    @Column(length = 2000)
    private String remarks;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}