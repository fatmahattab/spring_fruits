package com.fatma.fruits.restcontrollers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fatma.fruits.dto.FruitDTO;
import com.fatma.fruits.entities.Fruit;
import com.fatma.fruits.service.Fruitservice;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class FruitRESTController {

	@Autowired
	Fruitservice fruitservice;
	
	@RequestMapping(path="all",method=RequestMethod.GET)
	public List<FruitDTO> getAllFruits(){
		
		return fruitservice.getAllFruits();
	}
	
	@RequestMapping(value="/getbyid/{idSai}",method=RequestMethod.GET)
	public FruitDTO getFruitById(@PathVariable("idSai") Long idSai){
		
		return fruitservice.getFruit(idSai);
	}
	
	@RequestMapping(path="/addprod",method=RequestMethod.POST)
	public FruitDTO createFruit(@RequestBody FruitDTO fruitDto){
		
		return fruitservice.saveFruit(fruitDto);
	}
	
	
	
	@RequestMapping(path="/updateprod",method=RequestMethod.PUT)
	public FruitDTO updateFruit(@RequestBody FruitDTO produitDTO) {
		return fruitservice.updateFruit(produitDTO);
		}
	
	@RequestMapping(value="/delprod/{id}",method=RequestMethod.DELETE)
	public void deleteFruit(@PathVariable("id") Long id){
		
		 fruitservice.deleteFruitById(id);
	}
	
	@RequestMapping(value="/fSai/{id}",method=RequestMethod.GET)
    public List<Fruit> getFruitsBySaiId(@PathVariable("id") Long id){
		
		return fruitservice.findBySaisonIdSai(id);
	}
	
	@RequestMapping(value="/fruiByName/{nom}",method = RequestMethod.GET)
	public List<Fruit> findByNomFruitContains(@PathVariable("nom") String nom) {
	return fruitservice.findByNomFruitsContains(nom);
	}
//fSai

	
}
