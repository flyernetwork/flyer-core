package br.com.flyernetwork.core.flyercore.repository;


import org.springframework.stereotype.Repository;

import br.com.flyernetwork.core.flyercore.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    
    
}
