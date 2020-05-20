package com.spe.service;

import com.spe.model.Problems;
import com.spe.repository.ProblemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemsService {
    @Autowired
    ProblemsRepository problemsRepository;

    public List<Problems> findAll(){
        return problemsRepository.findAll();
    }
}
