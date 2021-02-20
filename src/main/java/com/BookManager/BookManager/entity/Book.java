package com.BookManager.BookManager.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ClassName Book
 * @Description 创建Book实体类
 * @Author Feng
 * @Date 2021/2/16 13:01
 * @Version 1.0
 */
//对实体类的注解，Hibernate映射对象都要有
@Entity
//@Data是lombok注解，用于自动生成get、set方法
@Data
public class Book {
//    @Id用于声明一个实体类的属性映射为数据库主键的注解
    @Id
    //@GeneratedValue用于标注主键的生成策略，设置主键自增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;

}
