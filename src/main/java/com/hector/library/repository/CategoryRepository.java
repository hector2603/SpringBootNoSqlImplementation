package com.hector.library.repository;

import com.hector.library.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {

    Category findByName(String name);

}
