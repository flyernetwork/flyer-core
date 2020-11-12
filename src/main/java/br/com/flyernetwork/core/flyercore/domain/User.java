package br.com.flyernetwork.core.flyercore.domain;

import java.math.BigInteger;

import lombok.Data;

@Data
public class User {

    User(){

    }

    public User(String name){
        this.name = name;
    }
    
    private String id;
    private String name;
    
}
