package com.example.vuecrud.main.controller;

import com.example.vuecrud.main.domain.Item;
import com.example.vuecrud.main.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController extends BaseController {

    private final MainService mainService;

    @GetMapping("/api/tutorials")
    public ResponseEntity<Map<String, Object>> getAll() {
        log.info("전체 목록 조회");
        List<Item> all = mainService.getAll();
        Map<String, Object> result = new HashMap<>();
        result.put("list", all);
        return createResponseEntity(true, result);
    }

    @GetMapping("/api/tutorials/{id}")
    public ResponseEntity<Map<String, Object>> getItems(@PathVariable("id") String id) {
        log.info("아이템 조회: {}", id);
        Item item = mainService.getItem(id);

        Map<String, Object> result = new HashMap<>();
        if (item != null) {
            result.put("item", item);
            return createResponseEntity(true, result);
        }
        return createResponseEntity(false, null);
    }

    @PostMapping("/api/tutorials")
    public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, Object> param) {
        log.info("아이템 등록: {}", param);
        String id = mainService.create(param);
        Map<String, Object> result = new HashMap<>();
        result.put("id", id);
        return createResponseEntity(true, result);
    }

    @PutMapping("/api/tutorials/{id}")
    public void update(@PathVariable("id") String id, @RequestBody Map<String, Object> param) {
        log.info("아이템 수정- id: {}, param: {}", id, param);
        mainService.update(id, param);
    }

    @DeleteMapping("/api/tutorials")
    public void deleteAll() {
        log.info("모든 아이템 삭제");
        mainService.deleteAll();
    }

    @DeleteMapping("/api/tutorials/{id}")
    public void deleteById(@PathVariable("id") String id) {
        log.info("삭제할 아이디: {}", id);
        mainService.deleteById(id);
    }

    @GetMapping("/api/tutorials/find/{title}")
    public ResponseEntity<Map<String, Object>> findByTitle(@PathVariable("title") String title) {
        log.info("제목으로 찾기: {}", title);
        List<Item> items = mainService.findByTitle(title);
        Map<String, Object> result = new HashMap<>();
        result.put("list", items);
        return createResponseEntity(true, result);
    }

}
