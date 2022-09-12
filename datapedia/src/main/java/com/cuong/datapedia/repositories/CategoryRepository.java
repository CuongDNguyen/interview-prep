package com.cuong.datapedia.repositories;

import com.cuong.datapedia.domain.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
}
