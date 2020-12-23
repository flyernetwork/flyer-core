package br.com.flyernetwork.core.flyercore.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class UserContent{

    @Id
    private String id;
    private String userId;
    private String title;
    private String userContent;
    private Date creationDate;

    // @Override
    public Object getContent() {
        return this.getUserContent();
    }
    
}
