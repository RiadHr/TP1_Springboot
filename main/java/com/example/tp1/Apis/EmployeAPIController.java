package com.example.tp1.Apis;


import com.example.tp1.Enteties.Employe;
import com.example.tp1.Enteties.Genre;
import com.example.tp1.Enteties.Departement;
import com.example.tp1.Enteties.Projet;
import com.example.tp1.Repository.EmployeRepository;
import com.example.tp1.Repository.DepartementRepository;
import com.example.tp1.Repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

    @RestController
    @RequestMapping("rsu")
    public class EmployeAPIController {
        @Autowired
        EmployeRepository employeRepository;

        @Autowired
        DepartementRepository departementRepository;

        @Autowired
        ProjetRepository projetRepository;


        //a
        //GET http://localhost:8082/rsu/departement/employe-projet?nomDepartement=Informatique
        @GetMapping("/departement")
        public List<String> getByNomDepApi(@RequestParam("nomDepartement") String nomDepartement) {
            return employeRepository.getByNomDep(nomDepartement);
        }


        //b
        //POST http://localhost:8082/rsu/employe?iddepart=1
        @PostMapping("/employe")
        public Employe insertEmpIntoDep(
        @RequestParam ("iddepart") Long idDepartement,@RequestBody Employe employe) {
            employe.setDepartement_table(departementRepository.findById(idDepartement).get());
            return employeRepository.save(employe);
        }


        //c
        //POST http://localhost:8082/rsu/employe2
        @PostMapping("/employe2")
        public Employe insertEmpIntoDep2(@RequestBody Map<String, Object> payload) {
            Employe e = new Employe();
            e.setNom(payload.get("nomEmp").toString());
            e.setEmail(payload.get("email").toString());

            Long idDepartement = Long.valueOf(payload.get("idDepartement").toString());
            e.setDepartement_table(departementRepository.findById(idDepartement).get());

            return employeRepository.save(e);
        }


      //d
//    PUT http://localhost:8081/rsu/employe/{id}
//    @PutMapping("/employe/{id}")
//    public Employe updateEmployePut(@PathVariable(value = "id") Long idEmp, @RequestBody Employe employe) {
//        return employeRepository.save(employe);
//    }


      //e
//      PUT http://localhost:8081/rsu/employe/{id}
//    @PatchMapping("/employe/{id}")
//    public Employe updateEmployePatch(@PathVariable(value = "id") Long idEmp, @RequestBody Employe employe) {
//        return employeRepository.save(employe);
//    }


      //f
      //PUT http://localhost:8081/rsu/projet/{idprojet}/{idemp}
        @PutMapping("/projet/projet/{idprojet}/{idemp}")
        public Employe addEmpToProjet(@PathVariable(value = "idprojet") Long idProjet,
                                      @PathVariable(value = "idemp") Long idEmp,
                                      @RequestBody Employe employe) {
            employe.setProjet_table(projetRepository.findById(idProjet).get());
            return employeRepository.save(employe);
        }


      //g
      //DELETE http://localhost:8081/rsu/projet/{idprojet}/{idemp}
//    @DeleteMapping("/projet/projet/{idprojet}/{idemp}")
//    public String DeleteEmpFromProjet(@RequestBody Employe employe,@PathVariable(value = "idprojet") Long idProjet,@PathVariable(value = "idemp") Long idEmp){
//
//        if(projetRepository.findById(idProjet).isPresent()){
//            if(employeRepository.findById(idEmp).isPresent()){
//                employe.setProjet(null);
//                return "Deleted correctly";
//            }
//        }
//        return "does not exist";
//    }


    }

