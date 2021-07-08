package br.com.flyernetwork.core.flyercore.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flyernetwork.core.flyercore.domain.User;
import br.com.flyernetwork.core.flyercore.resource.dto.UserDTO;
import br.com.flyernetwork.core.flyercore.service.AuthService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthResource {

    private static final String FLYER_API_VERSION_V1 = "flyercore-api-version=v1";

    @Autowired
    private AuthService authService;

    @PostMapping(headers = FLYER_API_VERSION_V1)
    public ResponseEntity<User> signIn(@RequestBody UserDTO user) {
        User userFound = this.authService.findUserByEmailAndPassword(user.email, user.password);
        return userFound != null ?
         new ResponseEntity<>(userFound,HttpStatus.OK) :
         new ResponseEntity<>(null,HttpStatus.NOT_FOUND); 
    }
}
