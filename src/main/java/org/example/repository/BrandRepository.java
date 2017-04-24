package org.example.repository;

import org.example.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {

	Brand findBrandById(long id);
}
