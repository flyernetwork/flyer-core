package br.com.flyernetwork.core.flyercore.service;

import java.util.List;

import br.com.flyernetwork.core.flyercore.domain.UserContent;

public interface FeedService {
    List<UserContent> userFeed(Integer userId);
}
