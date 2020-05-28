package com.spe.service;

import com.spe.model.Discussion;
import com.spe.repository.DiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DiscussionService {
    @Autowired
    DiscussionRepository discussionRepository;

    public List<Discussion> getDiscussion(){
        return discussionRepository.findByOrderByDojDesc();
    }

    public void saveDiscussion(Discussion discussion){
        discussionRepository.save(discussion);
    }
}
