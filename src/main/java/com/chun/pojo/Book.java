package com.chun.pojo;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private String publish;
    private String isbn;
    private String introduction;
    private String language;
    private Double price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    private Integer typeId;
    private Integer status;
    private Integer number;
    private Type type;


    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                ", isbn='" + isbn + '\'' +
                ", introduction='" + introduction + '\'' +
                ", language='" + language + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", typeId=" + typeId +
                ", status=" + status +
                ", number=" + number +
                ", type=" + type +
                '}';
    }

    public Book(Integer id, String name, String author, String publish, String isbn, String introduction, String language, Double price, Date publishDate, Integer typeId, Integer status,Integer number, Type type) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.isbn = isbn;
        this.introduction = introduction;
        this.language = language;
        this.price = price;
        this.publishDate = publishDate;
        this.typeId = typeId;
        this.status = status;
        this.number=number;
        this.type = type;

    }

}
