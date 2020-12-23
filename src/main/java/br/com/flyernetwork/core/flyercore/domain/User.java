package br.com.flyernetwork.core.flyercore.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "user")
public class User {
    
    @Id
    private String id;
    private String  name;
    private String email;
    private String password;
    private Address address;
    private List<String> friends = new ArrayList<String>();

    public boolean addFriend(String friendId){
        return this.friends.add(friendId);
    }
}
