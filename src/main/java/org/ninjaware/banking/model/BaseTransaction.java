package org.ninjaware.banking.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Base definition for fields common to all accounts
 */
public abstract  class BaseTransaction {

    @Id
    private String id;
    private String description;
    private LocalDateTime importedAt;
    private Status status;
    private UUID batchId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getImportedAt() {
        return importedAt;
    }

    public void setImportedAt(LocalDateTime importedAt) {
        this.importedAt = importedAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getBatchId() {
        return batchId;
    }

    public void setBatchId(UUID batchId) {
        this.batchId = batchId;
    }
}
