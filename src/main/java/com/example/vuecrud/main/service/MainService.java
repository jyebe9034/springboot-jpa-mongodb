package com.example.vuecrud.main.service;

import com.example.vuecrud.main.repository.MainRepository;
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

    /**
     * @Method Name : getAll
     * @Method 설명 : 전체 검색
     * @created : 2021. 06. 09.
     * @Author : jh.lim
     * @return item list
     */
    public List<Item> getAll() {
        return mainRepository.findAll();
    }

    /**
     * @Method Name : getItems
     * @Method 설명 : 아이템 한개 조회
     * @created : 2021. 06. 09.
     * @Author : jh.lim
     * @return item
     */
    public Item getItem(String id) {
        return mainRepository.findById(id).isPresent() ? mainRepository.findById(id).get() : null;
    }

    /**
     * @Method Name : create
     * @Method 설명 : 아이템 등록
     * @created : 2021. 06. 09.
     * @Author : jh.lim
     * @return id
     */
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

    /**
     * @Method Name : update
     * @Method 설명 : 아이템 수정
     * @created : 2021. 06. 09.
     * @Author : jh.lim
     */
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

    /**
     * @Method Name : deleteAll
     * @Method 설명 : 전체 삭제
     * @created : 2021. 06. 09.
     * @Author : jh.lim
     */
    @Transactional
    public void deleteAll() {
        mainRepository.deleteAll();
    }

    /**
     * @Method Name : deleteById
     * @Method 설명 : 아이템 한개 삭제
     * @created : 2021. 06. 09.
     * @Author : jh.lim
     */
    @Transactional
    public void deleteById(String id) {
        mainRepository.deleteById(id);
    }

    /**
     * @Method Name : findByTitleLike
     * @Method 설명 : 제목으로 Like 검색
     * @created : 2021. 06. 09.
     * @Author : jh.lim
     * @return item list
     */
    public List<Item> findByTitle(String title) {
        return mainRepository.findByTitleLike(title);
    }
}
