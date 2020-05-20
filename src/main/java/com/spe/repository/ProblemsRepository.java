package com.spe.repository;

import com.spe.model.Problems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemsRepository extends CrudRepository<Problems,Long> {
    List<Problems> findAll();
}
