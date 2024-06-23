package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.controller.dto.FertilizerDto;
import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.FertilizerService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Crop controller.
 */

@RestController
@RequestMapping("/crops")
public class CropController {

  @Autowired
  public CropService cropService;

  @Autowired
  public FertilizerService fertilizerService;

  @GetMapping
  public List<CropDto> getAllCrops() {
    return cropService.findAll();
  }

  @GetMapping("/{id}")
  public CropDto getCropById(@PathVariable Integer id) {
    Crop crop = cropService.findById(id);
    return CropDto.fromEntity(crop);
  }

  @GetMapping("/search")
  public List<CropDto> searchCrops(@RequestParam String start, @RequestParam String end) {
    return cropService.findByDate(start, end);
  }

  /**
   * Gets crop fertilizers.
   *
   * @param cropId the crop id
   * @return the crop fertilizers
   */
  @GetMapping("/{cropId}/fertilizers")
  public List<FertilizerDto> getCropFertilizers(@PathVariable Integer cropId) {
    Set<Fertilizer> fertilizers = cropService.getAllFertilizersByCropId(cropId);
    return fertilizers.stream()
        .map(FertilizerDto::fromEntity)
        .toList();
  }

  /**
   * Add fertilizer to crop response entity.
   *
   * @param cropId       the crop id
   * @param fertilizerId the fertilizer id
   * @return the response entity
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> addFertilizerToCrop(@PathVariable Integer cropId,
      @PathVariable Integer fertilizerId) {
    cropService.addFertilizerToCrop(cropId, fertilizerId);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body("Fertilizante e plantação associados com sucesso!");
  }
}
