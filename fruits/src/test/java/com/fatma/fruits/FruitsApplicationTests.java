package com.fatma.fruits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatma.fruits.entities.Fruit;
import com.fatma.fruits.entities.Saison;
import com.fatma.fruits.repos.FruitRepository;

@SpringBootTest
class FruitsApplicationTests {

	@Autowired
	private FruitRepository fruitRepository;
	@Test 
	public void testCreateFruit() {
	Fruit fr=new Fruit("asma",1500,new Date());
	fruitRepository.save(fr);
	}
	
	@Test 
	public void testFindFruit() {
	Fruit f=fruitRepository.findById(1L).get();
	System.out.println(f);
	}
	
	@Test 
	public void testUpdateFruit() {
	Fruit f=fruitRepository.findById(1L).get();
	f.setPrixFruit(2000.0);
	fruitRepository.save(f);
	System.out.println(f);
	}
	
	@Test 
	public void testDeleteFruit() {

	fruitRepository.deleteById(1L);
	//System.out.println(f);
	}
	
	@Test 
	public void testSindAllFruit() {
   List<Fruit> fr=fruitRepository.findAll();
	for(Fruit f:fr) {
		System.out.println(f);
	}
	}
	
	@Test 
	public void testFindFruitByNom() {
	List<Fruit >f=fruitRepository.findByNomFruit ("fraise");
	for(Fruit fr:f)
	{
		System.out.println(fr);
	}
	}
	@Test 
	
	public void testfindByNomFruitContains() {
	List<Fruit >f=fruitRepository.findByNomFruitContains ("a");
	for(Fruit fr:f)
	{
		System.out.println(fr);
	}
	}
	
	@Test 
	public void testfindByNomPrix() {
	List<Fruit >f=fruitRepository.findByNomPrix ("fraise",1000.0);
	for(Fruit fr:f)
	{
		System.out.println(fr);
	}
	}
	
	
	@Test 
	public void testfindBySaison() {
	Saison sai=new Saison();
	sai.setIdSai(1L);
	List<Fruit> f=fruitRepository.findBySaison(sai);
	for(Fruit fr:f)
	{
		System.out.println(fr);
	}
	
	}
	
	@Test 
	public void testfindBySaisonIdSai() {

	List<Fruit> f=fruitRepository.findBySaisonIdSai(1L);
	for(Fruit fr:f)
	{
		System.out.println(fr);
	}
	
	}
	
	@Test 
	public void testfindByOrderByNomFruitAsc() {

	List<Fruit> f=fruitRepository.findByOrderByNomFruitDesc();
	for(Fruit fr:f)
	{
		System.out.println(fr);
	}
	
	}
	
	@Test 
	public void testTrierFruitsNomsPrix() {

		List<Fruit> f=fruitRepository.trierFruitsNomsPrix();
		for(Fruit fr:f)
		{
			System.out.println(fr);
		}
		
		}
	
//	@Test
//	void contextLoads() {
//	}

}
