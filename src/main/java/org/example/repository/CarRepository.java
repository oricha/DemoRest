package org.example.repository;

import java.util.Collection;

import org.example.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

	Car findCarById(long id);

	Collection<Car> compareCarsByIds(long car_id1, long car_id2);
}
