package com.example.vuecrud.service;

import com.example.vuecrud.main.service.MainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@DisplayName("아이템 CRUD 테스트")
public class MainServiceTest {

    @Autowired
    MainService mainService;

    @Test
    @Rollback(false)
    @DisplayName("아이템 등록 테스트")
    public void createTest() {
        // given : 뭐가 주어졌을 때
        Map<String, Object> item = new HashMap<>();
        item.put("title", "testTitle");
        item.put("description", "It's a test");
        item.put("type", "BOOK");
        item.put("published", false);

        // when : 이렇게하면
        String id = mainService.create(item);

        // then : 결과가 이렇게 나와야한다
        Assertions.assertEquals("testTitle", mainService.getItem(id).getTitle());
    }

    @Test
    @Rollback(false)
    @DisplayName("아이템 수정 테스트")
    public void updateTest() {
        // given : 뭐가 주어졌을 때
        Map<String, Object> item = new HashMap<>();
        item.put("title", "updateTitle");
        item.put("description", "It's a update test");
        item.put("type", "MOVIE");
        item.put("published", true);

        // when : 이렇게하면
        String id = "60d02f3ab54d7f5a95afd7ce";
        mainService.update(id, item);

        // then : 결과가 이렇게 나와야한다
        Assertions.assertEquals("updateTitle", mainService.getItem(id).getTitle());
    }
}
