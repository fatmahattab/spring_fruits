package com.fatma.fruits.dto;

import java.util.Date;
import java.util.List;

import com.fatma.fruits.entities.Image;
import com.fatma.fruits.entities.Saison;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FruitDTO {
private Long idFruit;
private String nomFruit;
private Double prixFruit;
private Date datedebutsaison;

private Saison saison;
private List<Image> images;
private String nomSai;
}