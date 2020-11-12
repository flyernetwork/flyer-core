package br.com.flyernetwork.core.flyercore.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.flyernetwork.core.flyercore.domain.User;
import br.com.flyernetwork.core.flyercore.repository.UserRepository;
import br.com.flyernetwork.core.flyercore.resource.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserResource {

    @Autowired UserRepository userRepo;
    
    @PostMapping
    public ResponseEntity<ResponseStatus> createUser(
        @RequestBody UserDTO newUser
    ){
        /* TODO(tulio) - Nao Consigo Criar um usuario */
        this.log.info("Create!!!");
        this.userRepo.save(new User(newUser.name));
        return null;
    }

}
