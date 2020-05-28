package com.spe.repository;

import com.spe.model.ProblemDiscussion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemDiscussionRepository extends CrudRepository<ProblemDiscussion,Long> {
    List<ProblemDiscussion> findByPidOrderByDojDesc(Long pid);
}
