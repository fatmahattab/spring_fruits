package com.fatma.fruits.repos;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fatma.fruits.entities.Fruit;
import com.fatma.fruits.entities.Saison;

@RepositoryRestResource(path="rest")
public interface FruitRepository extends JpaRepository<Fruit, Long> {

	List<Fruit> findByNomFruit (String nom);
	List<Fruit> findByNomFruitContains (String nom);
	
//	@Query ("select f from Fruit f where f.nomFruit like %?1 and f.prixFruit > ?2")
//	List<Fruit> findByNomPrix(String nom,double prix);
	
	@Query ("select f from Fruit f where f.nomFruit like %:nom and f.prixFruit > :prix")
	List<Fruit> findByNomPrix (@Param("nom") String nom,@Param("prix") double prix);

	@Query ("select f from Fruit f where f.saison =?1")
	List<Fruit> findBySaison(Saison saison);
	
	List<Fruit> findBySaisonIdSai(Long id);
	
	List<Fruit> findByOrderByNomFruitDesc();
	
	@Query ("select f from Fruit f order by f.nomFruit ASC ,f.prixFruit DESC")
	List<Fruit> trierFruitsNomsPrix();
	
   
}
