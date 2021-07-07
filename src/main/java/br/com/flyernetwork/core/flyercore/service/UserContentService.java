package br.com.flyernetwork.core.flyercore.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.flyernetwork.core.flyercore.domain.UserContent;

public interface UserContentService {

    public UserContent addNewContent(UserContent newContent);
    public Optional<UserContent> getContentById(String contentId);
    public void removeUserContentById(String contentId); 
    public List<UserContent> findAllContent(); 
}
