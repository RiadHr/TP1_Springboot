package com.example.tp1.Enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "projet_table")
@NoArgsConstructor
@AllArgsConstructor
public class Projet {
    @Id
    @Column(name = "idprj")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;


    @Column(name="nom",length = 20)
    private String nom;


    @Temporal(TemporalType.DATE)
    private Date dureeRealisation;


    @OneToMany(mappedBy ="projet_table",fetch = FetchType.EAGER)
    private List<Employe> employe;

}
