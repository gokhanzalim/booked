package com.microservices.common.placeservice.repository.elastic;

import com.microservices.common.placeservice.entity.elastic.EsPlace;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticPlaceRepository extends ElasticsearchRepository<EsPlace,String> {
}
