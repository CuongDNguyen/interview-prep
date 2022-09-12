package com.cuong.datapedia.repositories;

import com.cuong.datapedia.domain.DataStructure;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DataStructureRepository extends ReactiveMongoRepository<DataStructure, String> {
}
