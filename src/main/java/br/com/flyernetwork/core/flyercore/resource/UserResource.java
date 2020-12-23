package br.com.flyernetwork.core.flyercore.resource;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.flyernetwork.core.flyercore.domain.User;
import br.com.flyernetwork.core.flyercore.repository.UserRepository;
import br.com.flyernetwork.core.flyercore.repository.projections.UserNoAddressProjection;
import br.com.flyernetwork.core.flyercore.resource.dto.UserDTO;
import br.com.flyernetwork.core.flyercore.service.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserResource {

    private final UserRepository userRepo;
    private final UserService userService;

    @Autowired
    UserResource(UserRepository userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @GetMapping(value = "")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping(value = "/{username}")
    public User getUserByName(@PathVariable(value = "username") String username) {
        // return this.userRepo.findUserByUsername(username).get();
        return this.userRepo.findByName(username).get(0);
    }

    @GetMapping(value = "/street/{streetname}")
    public User getUserByStreetname(@PathVariable(value = "streetname") String streetname) {
        return this.userRepo.findByStreetName(streetname).get(0);
    }

    // @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping()
    public ResponseEntity<ResponseStatus> createUser(@RequestBody User newUser) {
        User createdUser = this.userService.createUser(newUser);
        return createdUser != null ? new ResponseEntity<ResponseStatus>(HttpStatus.OK)
                : new ResponseEntity<ResponseStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping()
    public ResponseEntity<ResponseStatus> updateUser(@RequestBody User newUser) {
        User updatedUser = this.userService.updateUser(newUser);
        return updatedUser != null ? new ResponseEntity<ResponseStatus>(HttpStatus.OK)
                : new ResponseEntity<ResponseStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{userid}")
    public void deleteUser(@PathVariable(value = "userid") String id) {
        this.userService.deleteUser(id);
        // return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/friendship")
    public ResponseEntity<ResponseStatus> setFriendship(@RequestBody Map<String, String> request) {
        String user1Id = request.get("user1Id");
        String user2Id = request.get("user2Id");
        try {
            if (this.userService.setFriendship(user1Id, user2Id)) {
                return new ResponseEntity<ResponseStatus>(HttpStatus.OK);
            } else {
                return new ResponseEntity<ResponseStatus>(HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<ResponseStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}/friends")
    public ResponseEntity<?> getUserFriends(@PathVariable(name = "userId") String userId) {
        List<User> friends = this.userService.getAllUserFriends(userId);
        return new ResponseEntity(friends, HttpStatus.OK);
    }

}
