package com.example.tp1.Repository;

import com.example.tp1.Enteties.Employe;
import com.example.tp1.Enteties.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EmployeRepository extends JpaRepository<Employe,Long> {
    List<Employe> findEmployesByEmailContaining(String s);

    @Query("Select count(e.genre) from Employe e where e.genre =:genre" )
    Integer getNbrEmpByGenre(@Param("genre") Genre g);

    @Query(value="Select concat(e.idEmp, p.nomProjet) from employe_table e join projet_table p join departement_table where d.nomDepartement=:nomDepartement"
            , nativeQuery = true)
    List<String> getByNomDep(@Param("nomDep") String nomDep);

}
