package br.com.flyernetwork.core.flyercore.service;

import java.util.Optional;

import br.com.flyernetwork.core.flyercore.domain.User;
public interface AuthService {

    public Optional<User> findUser(User user);
    public User findUserByName(String username);
    public User findUserById(String id);
    public User findUserByEmailAndPassword(String email,String password);

}
