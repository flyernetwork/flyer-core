package br.com.flyernetwork.core.flyercore.resource;

import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flyernetwork.core.flyercore.domain.User;
import br.com.flyernetwork.core.flyercore.service.RegisterService;
import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RequestMapping("/register")
@RestController
@RequiredArgsConstructor
public class RegisterResource {

    private final RegisterService registerService;

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody HashMap<String,String> userPreRegister){
        User newUser = registerService.registerNewUser(userPreRegister);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/user/" + newUser.getId());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }
    
}
