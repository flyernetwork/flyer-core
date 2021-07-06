package br.com.flyernetwork.core.flyercore.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flyernetwork.core.flyercore.domain.UserContent;
import br.com.flyernetwork.core.flyercore.repository.UserContentRepository;

@Service
public class UserContentServiceImpl{

    private final UserContentRepository userContentRepository;

    @Autowired
    public UserContentServiceImpl(UserContentRepository userContentRepository) {
        this.userContentRepository = userContentRepository;
    }

    public UserContent addNewContent(UserContent newContent) {
        newContent.setCreationDate(new Date());
        return this.userContentRepository.save(newContent);
    }


    public List<UserContent> findAllContent() {
        return null;
    }


}
