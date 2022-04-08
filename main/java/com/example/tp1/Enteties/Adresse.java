package com.example.tp1.Enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adresse implements Serializable {


    private String rue;
    private Integer numero;
    private String codePostal;
    private String  ville;


    @ManyToOne
    private Departement departement;


    @ManyToOne
    private Projet projet;

}
