package br.com.flyernetwork.core.flyercore.domain;

import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String  name;
    private String email;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="friend_id")
    private List<User> friends;
}
