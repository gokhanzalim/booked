package com.microservices.common.placeservice.repository;

import com.microservices.common.placeservice.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place,String> {
}
