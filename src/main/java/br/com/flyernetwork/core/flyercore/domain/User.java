package br.com.flyernetwork.core.flyercore.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NonNull;

@Data
@Document(collection = "user")
public class User {
    
    @Id
    private String id;
    @NonNull
    private String  name;
    @NonNull
    private String email;
    @NonNull
    private String password;
    
}
