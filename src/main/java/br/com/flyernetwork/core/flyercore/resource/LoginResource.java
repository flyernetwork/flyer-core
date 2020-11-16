package br.com.flyernetwork.core.flyercore.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flyernetwork.core.flyercore.domain.User;
import br.com.flyernetwork.core.flyercore.repository.UserRepository;
import br.com.flyernetwork.core.flyercore.resource.dto.UserDTO;
import br.com.flyernetwork.core.flyercore.service.LoginService;
import br.com.flyernetwork.core.flyercore.service.impl.LoginServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginResource {

    private static final String FLYER_API_VERSION_V1 = "flyercore-api-version=v1";

    @Autowired
    private LoginService loginService;

    @PostMapping(headers = FLYER_API_VERSION_V1)
    public boolean signIn(@RequestBody UserDTO user) {
        this.loginService.findUser(null);
        
        // Optional<User> foundUser = this.userRepository.findUserByUsername(user.getName());
        // return foundUser.isPresent();
        return true;
    }
}
