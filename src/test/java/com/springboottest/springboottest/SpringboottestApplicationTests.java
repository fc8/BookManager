package com.springboottest.springboottest;

import com.BookManager.BookManager.entity.Book;
import com.BookManager.BookManager.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringboottestApplicationTests {
    @Autowired
    private BookRepository repository;
    @Test
    void contextLoads() {
    }

    @Test
    void Save(){
        Book book=new Book();
        book.setName("Java");
        book.setAuthor("张三");
        Book book1=repository.save(book);
        System.out.println(book1);
    }

    @Test
    void delete(){
        Book book=new Book();
        book.setId(16);
        repository.delete(book);
    }
}
