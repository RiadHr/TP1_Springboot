package com.example.tp1.Enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departement_table")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long numero;


    @Column(name = "nom",length = 20)
    private String nom;


    @OneToMany(mappedBy = "departement_table" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Employe> employes;
}
