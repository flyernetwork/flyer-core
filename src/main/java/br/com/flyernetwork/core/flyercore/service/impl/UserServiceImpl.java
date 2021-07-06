package br.com.flyernetwork.core.flyercore.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.amazonaws.services.apigateway.model.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.flyernetwork.core.flyercore.domain.User;
import br.com.flyernetwork.core.flyercore.repository.UserRepository;
import br.com.flyernetwork.core.flyercore.repository.projections.UserNoAddressProjection;
import br.com.flyernetwork.core.flyercore.resource.dto.UserDTO;
import br.com.flyernetwork.core.flyercore.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean setFriendship(String user1Id, String user2Id) throws Exception {
        Optional<User> user1 = this.userRepository.findById(user1Id);
        Optional<User> user2 = this.userRepository.findById(user2Id);

        if (!user1.isPresent()) {
            throw new Exception("User 1 not found");
        }
        if (!user2.isPresent()) {
            throw new Exception("User 1 not found");
        }
        User u1 = user1.get();
        User u2 = user2.get();

        this.userRepository.save(u1);
        this.userRepository.save(u2);

        return true;
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User foundUser = this.userRepository.findById(user.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "status"));
        foundUser = user;
        return this.userRepository.save(foundUser);

    }

    @Override
    public void deleteUser(String userId) {
        User foundUser = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "status"));
        this.userRepository.delete(foundUser);
    }

    @Override
    public Optional<User> findUserById(String userId) {
        return this.userRepository.findById(userId);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUserFriends(String userId) {
        Optional<User> user = this.userRepository.findById(userId);
        if (!user.isPresent()) return null;
        return null;
    }
}
