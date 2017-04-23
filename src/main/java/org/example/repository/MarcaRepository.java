package org.example.repository;

import org.example.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

	Marca findMarcaById(long id);
}
