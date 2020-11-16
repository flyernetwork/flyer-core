package br.com.flyernetwork.core.flyercore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flyernetwork.core.flyercore.domain.User;
public interface LoginService {

    public Optional<User> findUser(User user);
    public User findUserByName(String username);
    public User findUserById(String id);

}
