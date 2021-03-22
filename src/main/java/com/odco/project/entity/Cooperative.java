package com.odco.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="coop_tbl")
public class Cooperative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCoop;

    private String nomCoop;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cooperative")
    private List<Membre> membres;

    public Cooperative(int idCoop, String nomCoop){
        this.idCoop  = idCoop;
        this.nomCoop = nomCoop;
    }

}