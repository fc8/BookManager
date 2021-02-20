package com.BookManager.BookManager.controller;

import com.BookManager.BookManager.entity.Book;
import com.BookManager.BookManager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName BookHandler
 * @Description 实现增删改查的接口
 * @Author Feng
 * @Date 2021/2/16 13:42
 * @Version 1.0
 */

@RestController
//@RequestMapping是一个用来处理请求地址映射的注解，表示类中的所有响应请求方法都是以该地址作为父路径
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll/{page}")
//    @PathVariable用于替换GetMapping中的占位符，一般与get方法一起使用
    public Page<Book> findAll(@PathVariable("page") Integer page) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        return bookRepository.findAll(pageable);
    }

    @PostMapping("/addBook")
//    @RequestBody主要用于前端传给后端的json字符串，必须用于POST方式提交
    public String addBook(@RequestBody Book book) {
        Book result = bookRepository.save(book);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @PostMapping("/delBook")
    public void delBook(@RequestBody Book book) {
        System.out.println(book);
        bookRepository.delete(book);
    }

    //更新
    @PutMapping("/editBook")
    public String editBook(@RequestBody Book book) {
        Book b=bookRepository.findById(book.getId()).get();
        b.setAuthor(book.getAuthor());
        b.setName(book.getName());
        Book result = bookRepository.save(b);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }
}
