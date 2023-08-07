package com.cyrus.project;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventzMongoRepository extends MongoRepository<Event, String> {

}
