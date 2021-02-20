package com.BookManager.BookManager.repository;

import com.BookManager.BookManager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
//提供了数据库增删改查的接口，创建BookRepository接口继承
public interface BookRepository extends JpaRepository<Book,Integer>{
}
