package org.ninjaware.banking.persistence;

import org.ninjaware.banking.model.RaboStandardTransaction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Rabo standard specific repository
 */
@Repository("raboStandard")
public interface RaboStandardRepository extends MongoRepository<RaboStandardTransaction, String> {

    RaboStandardTransaction findById(String id);

}
