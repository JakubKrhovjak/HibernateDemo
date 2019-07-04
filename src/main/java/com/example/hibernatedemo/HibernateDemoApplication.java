package com.example.hibernatedemo;

import com.example.hibernatedemo.dao.ItemDao;
import com.example.hibernatedemo.dao.ItemDetailDao;
import com.example.hibernatedemo.dto.ItemDto;
import com.example.hibernatedemo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HibernateDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateDemoApplication.class, args);
    }

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ItemDetailDao itemDetailDao;

//    @PostConstruct
//    public void init() {
//        Item item = itemDao.save(new Item().setName("test-1"));
//        itemDetailDao.save(new ItemDetail().setDescription("detail-description").setItem(item));
//    }

//    @Transactional
    @GetMapping("/item")
    public ItemDto getItem() {
        Item item = itemDao.getOne(7L);
        return new ItemDto().setId(item.getItemId()).setName(item.getName()).setDetails(item.getItemDetails());

    }


}
