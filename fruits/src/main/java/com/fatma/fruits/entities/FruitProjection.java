package com.fatma.fruits.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="nomFruit",types={Fruit.class})
public interface FruitProjection {
public String  getNomFruit();
}
