package com.odco.project.controller;

import com.odco.project.entity.Cooperative;
import com.odco.project.service.CoopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin("*")
public class CoopController {

    @Autowired
    CoopService service;

    @GetMapping("/")
    public String home(HttpServletResponse response ){
        try {
            return("<h1>Hello</h1>");
        }catch(Exception exc){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product not found or broken quantity !", exc);
        }
    }

    @GetMapping("/admin")
    public String admin(){
        return("<h1>Hello</h1>");
    }

    @PostMapping("/coop")
    public Cooperative addCoop(@RequestBody Cooperative cooperative){
        return service.saveCoop(cooperative);
    }

    @GetMapping("/coop")
    public List<Cooperative> getAllCoop(){
        return service.getCoop();
    }

    @GetMapping("/coop/{idCoop}")
    public Cooperative getCoopById(@PathVariable(value = "idCoop") int idCoop){
        return service.getCoopById(idCoop);
    }

}
