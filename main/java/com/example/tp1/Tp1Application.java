package com.example.tp1;

import com.example.tp1.Enteties.Departement;
import com.example.tp1.Enteties.Employe;
import com.example.tp1.Enteties.Projet;
import com.example.tp1.Repository.DepartementRepository;
import com.example.tp1.Repository.EmployeRepository;
import com.example.tp1.Repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

import static com.example.tp1.Enteties.Genre.Mme;
import static com.example.tp1.Enteties.Genre.Mr;
import static com.example.tp1.Enteties.Genre.Melle;


@SpringBootApplication
public class Tp1Application implements CommandLineRunner {
    @Autowired
    DepartementRepository DepartementRepository;
    @Autowired
    ProjetRepository ProjetRepository;
    @Autowired
    EmployeRepository EmployeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        EmployeRepository.save(new Employe(null,"Samir","samir@esi-sba.dz",null,
        Mr, Date.valueOf("2005-05-20"),null,null));
        EmployeRepository.save(new Employe(null,"djamel","djamel@esi-sba.dz",null,
                Mme, Date.valueOf("2008-05-20"),null,null));
        EmployeRepository.save(new Employe(null,"karim","karim@gmail.com",null,
                Melle, Date.valueOf("2009-05-20"),null,null));

        DepartementRepository.save(new Departement(null,"Medcine",null));
        DepartementRepository.save(new Departement(null,"Informatique",null));
        DepartementRepository.save(new Departement(null,"Chimie",null));

        ProjetRepository.save(new Projet(null,"ecommerce",Date.valueOf("2008-05-03"),null));
        ProjetRepository.save(new Projet(null,"emedical",Date.valueOf("2008-05-03"),null));
        ProjetRepository.save(new Projet(null,"biochemie",Date.valueOf("2008-05-03"),null));
    }
}
