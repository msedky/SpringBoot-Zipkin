package org.zipkindemo.serviced.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.zipkindemo.serviced.model.entities.CitizenEntity;

@Repository
public interface CitizenRepository extends MongoRepository<CitizenEntity, String> {
}
