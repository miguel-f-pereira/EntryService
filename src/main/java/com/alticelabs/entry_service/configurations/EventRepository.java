package com.alticelabs.entry_service.configurations;

import com.alticelabs.common.models.Operation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Operation, String> {

}
