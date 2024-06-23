package com.betrybe.agrix.service;

import com.betrybe.agrix.controller.dto.FertilizerCreationDto;
import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.exception.FertilizerNotFoundException;
import com.betrybe.agrix.repository.FertilizerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Fertilizer service.
 */
@Service
public class FertilizerService {

  @Autowired
  private FertilizerRepository fertilizerRepository;

  /**
   * Create fertilizer fertilizer dto.
   *
   * @param fertilizerDto the fertilizer dto
   * @return the fertilizer dto
   */
  public FertilizerDto createFertilizer(FertilizerCreationDto fertilizerDto) {
    Fertilizer fertilizer = fertilizerDto.toEntity();
    Fertilizer savedFertilizer = fertilizerRepository.save(fertilizer);
    return FertilizerDto.fromEntity(savedFertilizer);
  }

  public List<Fertilizer> getAllFertilizers() {
    return fertilizerRepository.findAll();
  }

  public Fertilizer getFertilizerById(Integer id) {
    return fertilizerRepository.findById(id)
        .orElseThrow(FertilizerNotFoundException::new);
  }
}
