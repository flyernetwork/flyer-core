package br.com.flyernetwork.core.flyercore.repository;

import br.com.flyernetwork.core.flyercore.domain.UserContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface UserContentRepository extends CrudRepository<UserContent, UUID> {

}
