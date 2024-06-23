package com.betrybe.agrix.service;


import com.betrybe.agrix.dto.CropCreationDto;
import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.exception.FarmNotFoundException;
import com.betrybe.agrix.repository.CropRepository;
import com.betrybe.agrix.repository.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * The type Farm service.
 */
@Service
public class FarmService {

  @Autowired
  private FarmRepository farmRepository;

  @Autowired
  private CropRepository cropRepository;

  public Farm createFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> findAll() {
    return farmRepository.findAll();
  }

  public Farm findById(Integer id) {
    return farmRepository.findById(id)
        .orElseThrow(() -> new FarmNotFoundException("Fazenda não encontrada!"));
  }

  /**
   * Create crop crop dto.
   *
   * @param farmId  the farm id
   * @param cropDto the crop dto
   * @return the crop dto
   */
  public CropDto createCrop(Integer farmId, CropCreationDto cropDto) {
    Farm farmFromDb = farmRepository.findById(farmId)
        .orElseThrow(FarmNotFoundException::new);

    Crop crop = cropDto.toEntity(); // Convertendo o DTO para uma instância de Crop
    crop.setFarm(farmFromDb);
    Crop savedCrop = cropRepository.save(crop);

    return CropDto.fromEntity(savedCrop); // Convertendo a entidade Crop para o DTO CropDTO
  }

  /**
   * Gets crops by farm id.
   *
   * @param farmId the farm id
   * @return the crops by farm id
   */
  public List<CropDto> getCropsByFarmId(Integer farmId) {
    Farm farm = farmRepository.findById(farmId)
        .orElseThrow(FarmNotFoundException::new);

    List<Crop> crops = cropRepository.findAll();

    return cropRepository.findAll()
        .stream()
        .filter(crop -> farmId.equals(crop.getFarm().getId()))
        .map(CropDto::fromEntity)
        .toList();
  }
}
