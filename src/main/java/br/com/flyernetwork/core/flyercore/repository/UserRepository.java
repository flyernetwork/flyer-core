package br.com.flyernetwork.core.flyercore.repository;

import org.springframework.stereotype.Repository;

import br.com.flyernetwork.core.flyercore.domain.User;
import br.com.flyernetwork.core.flyercore.repository.projections.UserNoAddressProjection;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	Optional<User> findById(String id);
	// @Query("{ 'name' : ?0 }")
	// Optional<User> findUserByUsername(String username);
	List<User> findByName(String name);

	List<UserNoAddressProjection> findAllProjectedBy();

	@Query("{ 'address.street' : ?0 }")
	List<User> findByStreetName(String streetName);

	@Query("{'email':?0,'password':?1}")
	List<User> findByEmailAndPassword(String email, String password);
	
	List<User> findByIdIn(List<String> ids);

	

	

}
