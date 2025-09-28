package com.protsaha.brightfuture.repository;

import com.protsaha.brightfuture.model.TransportProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportProfileRepository extends MongoRepository<TransportProfile, String> {
}
