package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropCreationDto;
import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Farm controller.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  @Autowired
  private FarmService farmService;

  @GetMapping
  public List<Farm> getAllFarms() {
    return farmService.findAll();
  }

  @GetMapping("/{id}")
  public Farm getFarmById(@PathVariable Integer id) {
    return farmService.findById(id);
  }

  @GetMapping("/{farmId}/crops")
  public List<CropDto> getCropsByFarmId(@PathVariable Integer farmId) {
    return farmService.getCropsByFarmId(farmId);
  }

  @PostMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto createCrop(@PathVariable Integer farmId, @RequestBody CropCreationDto cropDto) {
    return farmService.createCrop(farmId, cropDto);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Farm createFarm(@RequestBody Farm farm) {
    return farmService.createFarm(farm);
  }

}
