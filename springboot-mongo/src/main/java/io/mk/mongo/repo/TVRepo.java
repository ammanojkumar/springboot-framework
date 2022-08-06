package io.mk.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.mk.mongo.model.TVChannel;

public interface TVRepo extends MongoRepository<TVChannel, Integer>{

}
