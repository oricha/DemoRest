package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Marca {
	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id_marca;
	
	private String name;

	public Marca(){}

	public Integer getId_marca() {
		return id_marca;
	}
	public void setId_marca(Integer id_marca) {
		this.id_marca = id_marca;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
