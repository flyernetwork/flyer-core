package br.com.flyernetwork.core.flyercore.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/user")
public class UserResource {

    @Autowired
    UserRepository userRepo;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping()
    public ResponseEntity<ResponseStatus> createUser(@RequestBody UserDTO newUser) {
        final User createdUser = this.userRepo.save(new User(newUser.name));
        return new ResponseEntity<ResponseStatus>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ResponseStatus> deleteUser(@RequestBody String id) {

        Optional<User> u = this.userRepo.findById("5fadc32a6a8c3d0977090aec");
        
        this.userRepo.deleteById("5fadc32a6a8c3d0977090aec");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
