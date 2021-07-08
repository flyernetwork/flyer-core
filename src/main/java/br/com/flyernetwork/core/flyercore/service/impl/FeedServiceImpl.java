package br.com.flyernetwork.core.flyercore.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.flyernetwork.core.flyercore.domain.UserContent;
import br.com.flyernetwork.core.flyercore.repository.UserContentRepository;
import br.com.flyernetwork.core.flyercore.service.FeedService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService {

    private final UserContentRepository userContentRepository;
    private final UserServiceImpl userServiceImpl;

    @Override
    public List<UserContent> userFeed(final Integer userId) {
//        return this.userContentRepository.findContentByFriendIdList(friendsIds.toArray(String[]::new));
        return null;
    }

}
