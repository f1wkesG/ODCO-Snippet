package com.odco.project.controller;


import com.odco.project.entity.Membre;
import com.odco.project.service.CoopService;
import com.odco.project.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
public class MembreController {

    @Autowired
    private MembreService service;
    @Autowired
    private CoopService coopService;

    @PostMapping("/coop/{idCoop}/membres")
    public Membre addMembre(@RequestBody Membre membre,
                            @PathVariable(value = "idCoop") int idCoop){
        membre.setCooperative(coopService.getCoopById(idCoop));
        return service.saveMembre(membre);
    }

    @GetMapping("/user")
    public String user(){
        return("<h1>Hello USER</h1>");
    }

    @GetMapping("/membres")
    public List<Membre> getMembres(){
        return service.getMembres();
    }

    @DeleteMapping("/membres/{id}")
    public String delMembre(@PathVariable(value = "id") int id){
        return service.deleteMembre(id);
    }

}
