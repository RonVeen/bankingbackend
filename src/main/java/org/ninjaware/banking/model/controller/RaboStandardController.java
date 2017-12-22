package org.ninjaware.banking.model.controller;

import org.ninjaware.banking.model.RaboStandardTransaction;
import org.ninjaware.banking.service.impl.RaboStandardTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;


/**
 * Rest controller for Rabo Standard
 */
@RestController
@RequestMapping(path = "/api/v1/rabostandard/")
public class RaboStandardController  {

    private RaboStandardTransactionService transactionService;

    @Autowired
    public RaboStandardController(RaboStandardTransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(path = "transaction/{id}")
    public ResponseEntity<RaboStandardTransaction> getTransaction(@PathVariable("id") String id) {
        Optional<RaboStandardTransaction> transactionOptional = transactionService.getTransaction(id);
        if (transactionOptional.isPresent()) {
            return ResponseEntity.ok(transactionOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping(path = "transaction")
    public ResponseEntity<?> createTransaction(@RequestBody RaboStandardTransaction transaction) {
        Optional<String> idOptional = transactionService.add(transaction);
        if (idOptional.isPresent()) {
            Optional<RaboStandardTransaction> transactionOptional = transactionService.getTransaction(idOptional.get());
            if (transactionOptional.isPresent()) {
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(transactionOptional.get().getId())
                        .toUri();
                return ResponseEntity.created(location).build();
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


}
