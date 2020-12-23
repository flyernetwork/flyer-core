package br.com.flyernetwork.core.flyercore.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.flyernetwork.core.flyercore.domain.UserContent;

@Repository
public interface UserContentRepository extends MongoRepository<UserContent, UUID> { 
    List<UserContent> findByUserId(UUID id);
}
