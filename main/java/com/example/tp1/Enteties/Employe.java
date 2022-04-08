package com.example.tp1.Enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employe {


    @Id
    @Column(name = "idEmp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;


    @Column(name = "nom", length = 20)
    private String nom;


    @Column(name = "email", unique = true)
    private String email;


    @Basic(fetch = FetchType.LAZY)
    @Embedded
    private Adresse adresse;


    @Enumerated(EnumType.STRING)
    private Genre genre;


    @Temporal(TemporalType.DATE)
    private Date date_embauche;


    @ManyToOne
    private Departement departement_table;


    @ManyToOne
    private Projet projet_table;



}
