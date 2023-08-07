package com.cyrus.project;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistrationsMongoRepository extends MongoRepository<Registration, String>{

}
