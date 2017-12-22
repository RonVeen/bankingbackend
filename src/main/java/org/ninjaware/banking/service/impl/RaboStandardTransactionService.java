package org.ninjaware.banking.service.impl;

import org.ninjaware.banking.model.BaseTransaction;
import org.ninjaware.banking.model.RaboStandardTransaction;
import org.ninjaware.banking.persistence.DefaultRepository;
import org.ninjaware.banking.persistence.RaboStandardRepository;
import org.ninjaware.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Rabo Standard implementation of the Transaction service
 */
@Service
public class RaboStandardTransactionService implements TransactionService<RaboStandardTransaction, String> {

    private RaboStandardRepository repository;

    @Autowired

    public RaboStandardTransactionService(@Qualifier("raboStandard") RaboStandardRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<String> add(RaboStandardTransaction transaction) {
        BaseTransaction result = repository.insert(transaction);
        return Optional.of(result.getId());
    }

    @Override
    public Optional<RaboStandardTransaction> getTransaction(String id) {
        RaboStandardTransaction transaction = repository.findOne(id);
        return transaction != null ? Optional.of(transaction) : Optional.empty();
    }
}
