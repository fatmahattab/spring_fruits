package com.fatma.fruits.restcontrollers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fatma.fruits.repos.SaisonRepository;
import com.fatma.fruits.entities.Saison;

@RestController
@RequestMapping("/api/Sai")
@CrossOrigin("*")
public class SaisonRESTController {
   @Autowired
   SaisonRepository saisonRepository;
   @RequestMapping(method=RequestMethod.GET)
   public List<Saison> getAllFruits()
   {
   return saisonRepository.findAll();
   }
   @RequestMapping(value="/{id}",method = RequestMethod.GET)
   public Saison getSaisonById(@PathVariable("id") Long id) {
   //return saisonRepository.findById(id).get();
	   return saisonRepository.findById(id).get();
   }
   
}
