package com.spe.repository;

import com.spe.model.Discussion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscussionRepository extends CrudRepository<Discussion,Long> {
    List<Discussion> findByOrderByDojDesc();
}
