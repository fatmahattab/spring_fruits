package com.fatma.fruits.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fatma.fruits.entities.Saison;

@RepositoryRestResource(path = "Sai")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular 
public interface SaisonRepository extends JpaRepository<Saison, Long> {

}
