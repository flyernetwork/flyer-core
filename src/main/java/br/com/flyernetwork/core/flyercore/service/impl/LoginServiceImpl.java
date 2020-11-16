package br.com.flyernetwork.core.flyercore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flyernetwork.core.flyercore.domain.User;
import br.com.flyernetwork.core.flyercore.repository.UserRepository;
import br.com.flyernetwork.core.flyercore.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findUser(User user) {
        // this.userRepository.findOne(user).
        return null;
    }

    @Override
    public User findUserById(String id) {
        return this.userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public User findUserByName(String username) {
        return this.userRepository.findByName(username).get(0);
    }

}
