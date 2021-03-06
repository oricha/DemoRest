package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Brand {
	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id_marca;
	private String name;

	public Brand(){}
	
}
