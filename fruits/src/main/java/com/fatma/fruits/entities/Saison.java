package com.fatma.fruits.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Saison {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSai;
	private String nomSai;
	private String descriptionSai;
	
	@OneToMany (mappedBy ="saison")
	@JsonIgnore 
	private List<Fruit> fruits;
	
	
	public List<Fruit> getFruits() {
		return fruits;
	}
	public void setFruits(List<Fruit> fruits) {
		this.fruits = fruits;
	}
	
//	public Saison () {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	public Long getIdSai() {
		return idSai;
	}
	public void setIdSai(Long idSai) {
		this.idSai = idSai;
	}
	public String getNomSai() {
		return nomSai;
	}
	public void setNomSai(String nomSai) {
		this.nomSai = nomSai;
	}
	public String getDescriptionSai() {
		return descriptionSai;
	}
	public void setDescriptionSai(String descriptionSai) {
		this.descriptionSai = descriptionSai;
	}
//	public Saison(Long idSai, String nomSai, String descriptionSai, List<Fruit> fruits) {
//		super();
//		this.idSai = idSai;
//		this.nomSai = nomSai;
//		this.descriptionSai = descriptionSai;
//		this.fruits = fruits;
//	}
	
	
	
	
	

}
