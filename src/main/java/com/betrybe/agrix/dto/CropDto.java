package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Crop;
import java.time.LocalDate;


/**
 * The type Crop dto.
 */
public record CropDto(Integer id, Integer farmId, String name, Double plantedArea,
                      LocalDate plantedDate, LocalDate harvestDate) {

  /**
   * From entity crop dto.
   *
   * @param crop the crop
   * @return the crop dto
   */
  public static CropDto fromEntity(Crop crop) {
    return new CropDto(
        crop.getId(),
        crop.getFarm().getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getPlantedDate(),
        crop.getHarvestDate()
    );
  }
}