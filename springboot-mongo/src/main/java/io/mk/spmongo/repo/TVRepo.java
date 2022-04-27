package io.mk.spmongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.mk.spmongo.model.TVChannel;

public interface TVRepo extends MongoRepository<TVChannel, Integer>{

}
