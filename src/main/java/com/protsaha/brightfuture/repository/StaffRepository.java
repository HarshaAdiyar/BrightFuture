package com.protsaha.brightfuture.repository;

import com.protsaha.brightfuture.model.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends MongoRepository<Staff, String> {
}
