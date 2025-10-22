package com.example.fullyUseOfRepository.repository;

import com.example.fullyUseOfRepository.models.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team,String> {
    Team findByName(String name);
}
