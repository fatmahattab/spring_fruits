package com.fatma.fruits.service;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatma.fruits.dto.FruitDTO;
import com.fatma.fruits.entities.Fruit;
import com.fatma.fruits.entities.Saison;
import com.fatma.fruits.repos.FruitRepository;
import com.fatma.fruits.repos.ImageRepository;

@Service
public class FruitServiceImpl implements Fruitservice{
    @Autowired
	FruitRepository fruitrepository;
    @Autowired
     ImageRepository imageRepository;
    @Autowired
    ModelMapper modelMapper;
	
	@Override
	public FruitDTO saveFruit(FruitDTO f) {
		// TODO Auto-generated method stub
		return convertEntityToDto(fruitrepository.save(convertDtoToEntity(f)));
	}

	/*@Override
	public Fruit updateFruit(Fruit f) {
		return fruitrepository.save(f);
	}*/



	@Override
	public FruitDTO updateFruit(FruitDTO f) {
	//Long oldProdImageId =this.getFruit(f.getIdFruit()).getImage().getIdImage();
  //   Long newProdImageId = f.getImage().getIdImage();
	//Fruit fruiUpdated = fruitrepository.save(f);
	//if (oldProdImageId != newProdImageId) //si l'image a été modifiée
	//imageRepository.deleteById(oldProdImageId);
	//return fruiUpdated;
		return convertEntityToDto(fruitrepository.save(convertDtoToEntity(f)));
	}

	@Override
	public void deleteFruit(Fruit f) {
		fruitrepository.delete(f);
		
		
	}

	@Override
	public void deleteFruitById(Long id) {
		fruitrepository.deleteById(id);
		/*FruitDTO p =  getFruit(id);
		 //suuprimer l'image avant de supprimer le produit
		try {
		//Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
			
		} catch (IOException e) {
		e.printStackTrace();
		}*/
		
	}
	/*@Override
	public void deleteFruitById(Long id) {
	 Fruit p = getFruit(id);
	 //suuprimer l'image avant de supprimer le produit
	try {
	Files.delete(Paths.get(System.getProperty("user.home")+"/Pictures/"+p.getImagePath()));
	} catch (IOException e) {
	e.printStackTrace();
	}
	fruitrepository.deleteById(id);
	}*/

	
	
	@Override
	public FruitDTO getFruit(Long id) {
		return convertEntityToDto( fruitrepository.findById(id).get());
		
	}

	@Override
	public List<FruitDTO> getAllFruits() {
		// TODO Auto-generated method stub
		/*return fruitrepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());*/
		List<FruitDTO> f=new ArrayList<>();
		for(Fruit l: this.fruitrepository.findAll()) {
			f.add(this.convertEntityToDto(l));
		}
		
		return f;
	}

	@Override
	public List<Fruit> findByNomFruits(String nom) {
		// TODO Auto-generated method stub
		return fruitrepository.findByNomFruit(nom);
	}

	@Override
	public List<Fruit> findByNomFruitsContains(String nom) {
		// TODO Auto-generated method stub
		return fruitrepository.findByNomFruitContains(nom);
	}

	@Override
	public List<Fruit> findByNomPrix(String nom, double prix) {
		// TODO Auto-generated method stub
		return fruitrepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Fruit> findBySaison(Saison saison) {
		// TODO Auto-generated method stub
		return fruitrepository.findBySaison(saison);
	}

	@Override
	public List<Fruit> findBySaisonIdSai(Long id) {
		// TODO Auto-generated method stub
		return fruitrepository.findBySaisonIdSai(id);
	}

	@Override
	public List<Fruit> findByOrderByNomFruitDesc() {
		// TODO Auto-generated method stub
		return fruitrepository.findByOrderByNomFruitDesc();
	}

	@Override
	public List<Fruit> trierFruitsNomsPrix() {
		// TODO Auto-generated method stub
		return fruitrepository.trierFruitsNomsPrix();
	}
	
	@Override
	public FruitDTO convertEntityToDto(Fruit fruit) {
		/*FruitDTO fruitDTO = new FruitDTO();
		fruitDTO.setIdFruit(fruit.getIdFruit());
		fruitDTO.setNomFruit(fruit.getNomFruit());
		fruitDTO.setPrixFruit(fruit.getPrixFruit());
		fruitDTO.setDatedebutsaison(fruit.getDatedebutsaison());
		fruitDTO.setSaison(fruit.getSaison());
		fruitDTO.setImages(fruit.getImages());
		
	 return fruitDTO;

	 /*return ProduitDTO.builder()
	.idProduit(produit.getIdProduit())
	.nomProduit(produit.getNomProduit())
	.prixProduit(produit.getPrixProduit())
	.dateCreation(p.getDateCreation())
	.categorie(produit.getCategorie())
	.build();*/
		
		 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		 FruitDTO produitDTO = modelMapper.map(fruit, FruitDTO.class);
		
		 return produitDTO; 
	}
	@Override
	public Fruit convertDtoToEntity(FruitDTO produitDto) {
	/*Fruit produit = new Fruit();
	produit.setIdFruit(fruitDto.getIdFruit());
	produit.setNomFruit(fruitDto.getNomFruit());
	produit.setPrixFruit(fruitDto.getPrixFruit());
	produit.setDatedebutsaison(fruitDto.getDatedebutsaison());
	produit.setSaison(fruitDto.getSaison());
	 return produit;*/
		Fruit produit = new Fruit();
		produit = modelMapper.map(produitDto, Fruit.class);
		return produit;
	}
}
