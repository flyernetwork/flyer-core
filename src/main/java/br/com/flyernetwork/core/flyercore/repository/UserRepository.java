package br.com.flyernetwork.core.flyercore.repository;

import br.com.flyernetwork.core.flyercore.domain.User;
import br.com.flyernetwork.core.flyercore.repository.projections.UserNoAddressProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

	Optional<User> findById(String id);
	// @Query("{ 'name' : ?0 }")
	// Optional<User> findUserByUsername(String username);
	List<User> findByName(String name);

	List<UserNoAddressProjection> findAllProjectedBy();

	List<User> findByEmailAndPassword(String email, String password);

	List<User> findByIdIn(List<String> ids);

	

	

}
