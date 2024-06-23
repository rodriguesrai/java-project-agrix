package com.betrybe.agrix.service;

import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.exception.CropNotFoundException;
import com.betrybe.agrix.repository.CropRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Crop service.
 */
@Service
public class CropService {

  @Autowired
  private CropRepository cropRepository;

  @Autowired
  FertilizerService fertilizerService;

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<CropDto> findAll() {
    return cropRepository.findAll().stream()
        .map(CropDto::fromEntity)
        .toList();
  }

  /**
   * Find by id crop dto.
   *
   * @param id the id
   * @return the crop dto
   */
  public Crop findById(Integer id) {
    List<Crop> cropsFromDb = cropRepository.findAll();
    return cropsFromDb.stream()
        .filter(crop -> crop.getId().equals(id))
        .findFirst()
        .orElseThrow(CropNotFoundException::new);
  }


  /**
   * Find by date list.
   *
   * @param start the start
   * @param end   the end
   * @return the list
   */
  public List<CropDto> findByDate(String start, String end) {
    LocalDate startDate = LocalDate.parse(start);
    LocalDate endDate = LocalDate.parse(end);

    return cropRepository.findAll().stream()
        .filter(crop -> crop.getHarvestDate().isAfter(startDate) && crop.getHarvestDate()
            .isBefore(endDate))
        .map(CropDto::fromEntity)
        .toList();
  }

  /**
   * Add fertilizer to crop.
   *
   * @param cropId       the crop id
   * @param fertilizerId the fertilizer id
   */
  public void addFertilizerToCrop(Integer cropId, Integer fertilizerId) {
    Crop cropDto = findById(cropId);
    Fertilizer fertilizer = fertilizerService.getFertilizerById(fertilizerId);
    cropDto.getFertilizers().add(fertilizer);
    cropRepository.save(cropDto);
  }

  public Set<Fertilizer> getAllFertilizersByCropId(Integer cropId) {
    Crop crop = findById(cropId);
    return crop.getFertilizers();
  }
}
