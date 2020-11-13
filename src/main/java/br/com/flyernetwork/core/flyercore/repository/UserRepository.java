package br.com.flyernetwork.core.flyercore.repository;


import org.springframework.stereotype.Repository;

import br.com.flyernetwork.core.flyercore.domain.User;
import br.com.flyernetwork.core.flyercore.resource.S;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

	void findOne(Example<S> user);
    
    
}
