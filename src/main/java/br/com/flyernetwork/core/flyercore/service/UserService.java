package br.com.flyernetwork.core.flyercore.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import br.com.flyernetwork.core.flyercore.domain.User;

public interface UserService {
    public Iterable<User> getAllUsers();
    public User createUser(User user);
    public User updateUser(User user);
    public void deleteUser(String userId);
    public Optional<User> findUserById(String userId);

    public boolean setFriendship(String user1Id,String user2Id) throws Exception;
    public List<User> getAllUserFriends(String userId);
}
