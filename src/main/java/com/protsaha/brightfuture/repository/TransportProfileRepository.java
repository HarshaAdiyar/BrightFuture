package com.protsaha.brightfuture.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportProfileRepository extends MongoRepository<TransportProfile, String> {
}
