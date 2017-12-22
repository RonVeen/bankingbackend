package org.ninjaware.banking.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;
import java.util.Optional;

/**
 * Untyped base repository
 */
public interface DefaultRepository { //<T, ID extends Serializable> extends MongoRepository<T, ID> {


}
