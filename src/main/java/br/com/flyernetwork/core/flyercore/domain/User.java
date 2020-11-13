package br.com.flyernetwork.core.flyercore.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {

    User(){

    }

    public User(String name){
        this.name = name;
    }
    
    @Id
    private String id;
    private String name;
    
}
