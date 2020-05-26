package com.microservices.common.placeservice.service;

import com.microservices.common.placeservice.dto.PlaceDto;

import java.util.List;

public interface PlaceService {

    PlaceDto save(PlaceDto placeDto);

    PlaceDto update(String id, PlaceDto placeDto);

    Boolean delete(String id);

    PlaceDto findById(String id);

    List<PlaceDto> findAll();


}
