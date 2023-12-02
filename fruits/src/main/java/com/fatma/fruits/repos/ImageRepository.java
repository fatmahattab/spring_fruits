package com.fatma.fruits.repos;



import org.springframework.data.jpa.repository.JpaRepository;


import com.fatma.fruits.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
	//@Query ("delete f from Image f where f.fruit_id like %?1")
	//List<Fruit> deleteParidFruits();
}
