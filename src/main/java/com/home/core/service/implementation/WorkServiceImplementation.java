package com.home.core.service.implementation;

import com.home.core.model.Work;
import com.home.core.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImplementation {

    @Autowired
    WorkRepository workRepository;

    public List<Work> getAllWorks(){
        return workRepository.findAll();
    }

    public String saveWork(Work work){
        workRepository.save(work);
        return "complete saved";
    }

}
