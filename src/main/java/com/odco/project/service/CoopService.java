package com.odco.project.service;


import com.odco.project.entity.Cooperative;
import com.odco.project.repository.CoopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoopService {

    @Autowired
    private CoopRepository repository;

    public Cooperative saveCoop(Cooperative cooperative){
        return repository.save(cooperative);
    }

    public List<Cooperative> getCoop(){
        return repository.findAll();
    }

    public Cooperative getCoopById(int id){
        return repository.findById(id).orElse(null);
    }

    public String deleteCoop(int id){
        repository.deleteById(id);
        return "Cooperative deleted"+id;
    }

}
