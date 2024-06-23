package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.FertilizerCreationDto;
import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.service.FertilizerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Fertilizer controller.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  @Autowired
  private FertilizerService fertilizerService;

  /**
   * Gets all fertilizers.
   *
   * @return the all fertilizers
   */
  @GetMapping
  public ResponseEntity<List<FertilizerDto>> getAllFertilizers() {
    List<Fertilizer> fertilizers = fertilizerService.getAllFertilizers();
    List<FertilizerDto> fertilizerDtos = fertilizers.stream()
        .map(FertilizerDto::fromEntity)
        .toList();
    return ResponseEntity.ok(fertilizerDtos);
  }

  /**
   * Gets fertilizer by id.
   *
   * @param id the id
   * @return the fertilizer by id
   */
  @GetMapping("/{id}")
  public ResponseEntity<FertilizerDto> getFertilizerById(@PathVariable Integer id) {
    Fertilizer fertilizer = fertilizerService.getFertilizerById(id);
    FertilizerDto fertilizerDto = FertilizerDto.fromEntity(fertilizer);
    return ResponseEntity.ok(fertilizerDto);
  }

  @PostMapping
  public ResponseEntity<FertilizerDto> createFertilizer(
      @RequestBody @Validated FertilizerCreationDto fertilizerCreationDto) {
    FertilizerDto createdFertilizer = fertilizerService.createFertilizer(fertilizerCreationDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdFertilizer);
  }

}
