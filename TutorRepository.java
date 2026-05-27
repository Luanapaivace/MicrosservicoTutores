package com.univet.br.tutor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.univet.br.tutor.model.Tutor;

public interface TutorRepository extends MongoRepository<Tutor, String> {

}
