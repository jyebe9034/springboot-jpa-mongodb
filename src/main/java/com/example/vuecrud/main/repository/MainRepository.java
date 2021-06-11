package com.example.vuecrud.main.repository;

import com.example.vuecrud.main.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainRepository extends MongoRepository<Item, String> {

    /**
     * @Method Name : findByTitleLike
     * @Method 설명 : 제목으로 Like 검색
     * @created : 2021. 06. 09.
     * @Author : jh.lim
     * @return item list
     */
    List<Item> findByTitleLike(String title);
}
