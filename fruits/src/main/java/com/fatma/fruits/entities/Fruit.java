package com.fatma.fruits.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Fruit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
private long idFruit;
private String nomFruit;
private double prixFruit;
private Date datedebutsaison;
@ManyToOne
private Saison saison;
/*@OneToOne
private Image image;*/
@OneToMany (mappedBy = "fruit")
private List<Image> images;

//private String imagePath;


public Fruit() {
	super();
	// TODO Auto-generated constructor stub
}

public Saison getSaison() {
	return saison;
}

public void setSaison(Saison saison) {
	this.saison = saison;
}


public Fruit(String nomFruit, double prixFruit, Date datedebutsaison) {
	super();
	this.nomFruit = nomFruit;
	this.prixFruit = prixFruit;
	this.datedebutsaison = datedebutsaison;
}



public long getIdFruit() {
	return idFruit;
}
public void setIdFruit(long idFruit) {
	this.idFruit = idFruit;
}
public String getNomFruit() {
	return nomFruit;
}
public void setNomFruit(String nomFruit) {
	this.nomFruit = nomFruit;
}
public double getPrixFruit() {
	return prixFruit;
}
public void setPrixFruit(double prixFruit) {
	this.prixFruit = prixFruit;
}
public Date getDatedebutsaison() {
	return datedebutsaison;
}
public void setDatedebutsaison(Date datedebutsaison) {
	this.datedebutsaison = datedebutsaison;
}

@Override
public String toString() {
	return "Fruit [idFruit=" + idFruit + ", nomFruit=" + nomFruit + ", prixFruit=" + prixFruit + ", datedebutsaison="
			+ datedebutsaison + "]";
}




public List<Image> getImages() {
	return images;
}

public void setImages(List<Image> images) {
	this.images = images;
}





}
