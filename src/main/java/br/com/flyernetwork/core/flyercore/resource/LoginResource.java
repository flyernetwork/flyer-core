package br.com.flyernetwork.core.flyercore.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flyernetwork.core.flyercore.repository.UserRepository;
import br.com.flyernetwork.core.flyercore.resource.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginResource {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public boolean signIn(UserDTO user) {
        this.userRepository.findOne((Example<S>) user);
    }
}
