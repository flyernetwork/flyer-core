package br.com.flyernetwork.core.flyercore.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flyernetwork.core.flyercore.domain.User;
import br.com.flyernetwork.core.flyercore.resource.dto.UserDTO;
import br.com.flyernetwork.core.flyercore.service.LoginService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginResource {

    private static final String FLYER_API_VERSION_V1 = "flyercore-api-version=v1";

    @Autowired
    private LoginService loginService;

    @PostMapping(headers = FLYER_API_VERSION_V1)
    public ResponseEntity<User> signIn(@RequestBody UserDTO user) {
        User userFound = this.loginService.findUserByEmailAndPassword(user.email, user.password);
        return userFound != null ?
         new ResponseEntity<>(userFound,HttpStatus.OK) :
         new ResponseEntity<>(null,HttpStatus.NOT_FOUND); 
    }
}
