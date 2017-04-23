package org.example.controller;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entities.Car;
import org.example.entities.Marca;
import org.example.repository.CarRepository;
import org.example.repository.MarcaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/car")
public class CarController {
	
	private static final Logger log = LoggerFactory.getLogger(CarController.class);
	
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private MarcaRepository marcaRepository; 


	/**
	 * Find car by Id
	 * GET /car/$transaction_id
	 * Returns: { "amount":double,"type":string,"parent_id":long } 
	 * @return
	 */
	@RequestMapping(value = "/{car_id}", method = RequestMethod.GET)
	public @ResponseBody Car getTransaction(@PathVariable long car_id){
		
		return carRepository.findCarById(car_id);
	}
	
	/**
	 * Compare cars by Ids
	 * GET /car/$transaction_id
	 * Returns: { "amount":double,"type":string,"parent_id":long } 
	 * @return
	 */
	@RequestMapping(value = "/{car_id1/car_id2}", method = RequestMethod.GET)
	public @ResponseBody Collection<Car> compareCars(@PathVariable long car_id1, @PathVariable long car_id2){
		
		return carRepository.compareCarsByIds(car_id1, car_id2);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{car_id}", method = RequestMethod.GET)
	public @ResponseBody Collection<Marca> listMarcas(){
		
		return marcaRepository.findAll();
	}
}
