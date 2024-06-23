package com.betrybe.agrix.repository;

import com.betrybe.agrix.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The type Crop repository.
 */
@Repository
public interface CropRepository extends JpaRepository<Crop, Integer> {

}
