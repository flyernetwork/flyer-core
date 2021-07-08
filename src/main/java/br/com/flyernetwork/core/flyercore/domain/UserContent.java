package br.com.flyernetwork.core.flyercore.domain;

import java.util.Date;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class UserContent{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String userId;
    private String title;
    private String userContent;
    private Date creationDate;

    // @Override
    public Object getContent() {
        return this.getUserContent();
    }
    
}
