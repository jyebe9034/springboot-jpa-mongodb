package com.example.vuecrud.main.repository;

import com.example.vuecrud.main.MainRepository;
import com.example.vuecrud.main.domain.Item;
import com.example.vuecrud.main.domain.Type;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainService {

    private final MainRepository mainRepository;

    public List<Item> getAll() {
        return mainRepository.findAll();
    }

    public Item getItem(String id) {
        return mainRepository.findById(id).isPresent() ? mainRepository.findById(id).get() : null;
    }

    @Transactional
    public String create(Map<String, Object> param) {
        Item item = new Item();
        item.setTitle(Objects.toString(param.get("title")));
        item.setDescription(Objects.toString(param.get("description")));
        item.setType(Type.valueOf(Objects.toString(param.get("type"))));
        item.setPublished((boolean) param.get("published"));
        mainRepository.save(item);
        return item.getId();
    }

    @Transactional
    public void update(String id, Map<String, Object> param) {
        Optional<Item> byId = mainRepository.findById(id);
        if (byId.isPresent()) {
            Item item = byId.get();
            item.setTitle(Objects.toString(param.get("title")));
            item.setDescription(Objects.toString(param.get("description")));
            item.setType(Type.valueOf(Objects.toString(param.get("type"))));
            item.setPublished((boolean) param.get("published"));
            mainRepository.save(item);
        }
    }

    @Transactional
    public void deleteAll() {
        mainRepository.deleteAll();
    }

    @Transactional
    public void deleteById(String id) {
        mainRepository.deleteById(id);
    }

    public List<Item> findByTitle(String title) {
        return mainRepository.findByTitleLike(title);
    }
}
