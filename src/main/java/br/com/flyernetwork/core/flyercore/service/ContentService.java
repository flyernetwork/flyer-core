package br.com.flyernetwork.core.flyercore.service;

import java.util.List;

import br.com.flyernetwork.core.flyercore.domain.Content;

public interface ContentService {
    public Content addNewContent(Content newContent);
    public List<Content> findAllContent();
}
