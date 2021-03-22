package com.odco.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="membre_tbl")
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "idCoop", nullable = false)
    @JsonBackReference
    private Cooperative cooperative;

    private int idProfil;

    private String nomComplet;
    private String sexe;
    private String cin;
    private String email;
    private String tel;


    public Membre(int id, int idProfil, String nomComplet, String sexe, String cin, String email, String tel) {
        this.id = id;
        this.idProfil = idProfil;
        this.nomComplet = nomComplet;
        this.sexe = sexe;
        this.cin = cin;
        this.email = email;
        this.tel = tel;
    }

    public void setCooperative(Cooperative cooperative){
        this.cooperative = cooperative;
    }

}
