package com.example.hibernatedemo;

import com.example.hibernatedemo.dao.BookDao;
import com.example.hibernatedemo.dao.DetailDao;
import com.example.hibernatedemo.entity.Book;
import com.example.hibernatedemo.entity.Detail;
import com.example.hibernatedemo.entity.Item;
import com.example.hibernatedemo.entity.ItemDetail;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Jakub krhovják on 5/8/19.
 */


public class AccountTest extends HibernateDemoApplicationTests {


    @Autowired
    private BookDao bookDao;

    @Autowired
    private DetailDao detailDao;

    @Before
    public void setUp() throws Exception {
        bookDao.save(new Book().setAccount("test-1"));

    }

    @Test
    public void accountTest() {
        detailDao.save(new Detail().setBook(new Book().setId(29L).setAccount("test-1")));
    }

    @Test
    public void oneToMany() {
        Item item = new Item().setItemId(7L);

        ItemDetail itemDetail = new ItemDetail().setDescription("desc").setItem(item);
        itemDetailDao.save(itemDetail);

//        detailDao.save(new Detail().setBook(new Book().setId(29L).setAccount("test-1")));
    }
}
