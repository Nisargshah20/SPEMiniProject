package com.spe.service;

import com.spe.model.ProblemDiscussion;
import com.spe.repository.ProblemDiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemDiscussionService {
    @Autowired
    ProblemDiscussionRepository problemDiscussionRepository;

    public List<ProblemDiscussion> getProblemDiscussion(Long pid){
        return problemDiscussionRepository.findByPidOrderByDojDesc(pid);
    }

    public void saveDiscussion(ProblemDiscussion discussion){
        problemDiscussionRepository.save(discussion);
    }

}
