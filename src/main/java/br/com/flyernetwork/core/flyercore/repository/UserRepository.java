package br.com.flyernetwork.core.flyercore.repository;

import org.springframework.stereotype.Repository;

import br.com.flyernetwork.core.flyercore.domain.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	// @Query("{ 'name' : ?0 }")
	// Optional<User> findUserByUsername(String username);

	List<User> findByName(String name);


}
