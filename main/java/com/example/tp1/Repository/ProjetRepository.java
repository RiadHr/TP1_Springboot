package com.example.tp1.Repository;

import com.example.tp1.Enteties.Projet;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjetRepository extends JpaRepository<Projet,Long> {

}
