package com.example.vuecrud.main.repository;

import com.example.vuecrud.main.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainRepository extends MongoRepository<Item, String> {

    List<Item> findByTitleLike(String title);
}
