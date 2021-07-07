package br.com.flyernetwork.core.flyercore.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.flyernetwork.core.flyercore.domain.User;
import br.com.flyernetwork.core.flyercore.repository.UserRepository;
import br.com.flyernetwork.core.flyercore.service.RegisterService;
import br.com.flyernetwork.core.flyercore.service.UserService;
import br.com.flyernetwork.core.flyercore.utils.Constants;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegisterServiceImpl implements RegisterService{

    private final UserRepository userRepository;
    private final UserService userSerivce;

	@Override
	public User registerNewUser(Map<String, String> userData) throws ResponseStatusException{

        String name = userData.get("name");
        String email = userData.get("email");
        String password = userData.get("password");

/*        Optional<User> foundUser = userRepository.findByEmail(email);
        if(foundUser.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.USER_EMAIL_ALREADY_REGISTRED );
        }

        User newUser = User.builder()
        .name(name)
        .email(email)
        .password(password)
        .build();*/
		
		return null;
	}

}
