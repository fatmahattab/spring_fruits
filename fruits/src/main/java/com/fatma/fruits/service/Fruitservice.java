package com.fatma.fruits.service;

import java.util.List;

import com.fatma.fruits.dto.FruitDTO;
import com.fatma.fruits.entities.Fruit;
import com.fatma.fruits.entities.Saison;

public interface Fruitservice {
FruitDTO saveFruit(FruitDTO f);
FruitDTO updateFruit(FruitDTO f);
void deleteFruit(Fruit f);
void deleteFruitById(Long id);
FruitDTO getFruit(Long id);

List<FruitDTO> getAllFruits();


List<Fruit> findByNomFruits(String nom);
List<Fruit> findByNomFruitsContains(String nom);
List<Fruit> findByNomPrix(String nom,double prix);
List<Fruit> findBySaison(Saison saison);
List<Fruit> findBySaisonIdSai(Long id);
List<Fruit>  findByOrderByNomFruitDesc();
List<Fruit>  trierFruitsNomsPrix();
FruitDTO convertEntityToDto (Fruit fruit);

Fruit convertDtoToEntity(FruitDTO fruitDto);

}
