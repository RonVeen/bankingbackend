package org.ninjaware.banking.service;


import java.io.Serializable;
import java.util.Optional;

/**
 * Created by veenr on 20-12-2017.
 */
public interface TransactionService<T, ID extends Serializable> {

    public Optional<ID> add(T t);

    public Optional<T> getTransaction(ID id);

}
