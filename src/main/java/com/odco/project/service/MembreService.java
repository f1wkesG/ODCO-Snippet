package com.odco.project.service;

import com.odco.project.entity.Membre;
import com.odco.project.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembreService {

    @Autowired
    private MembreRepository repository;

    public Membre saveMembre(Membre membre){
        return repository.save(membre);
    }

    public List<Membre> getMembres(){
        return repository.findAll();
    }

    public String deleteMembre(int id){
        repository.deleteById(id);
        return "Membre deleted !" + id;
    }

}
