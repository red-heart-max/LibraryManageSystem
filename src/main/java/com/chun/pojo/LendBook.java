package com.chun.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class LendBook {
    /**
     * id
     */
    private Integer id;
    /**
     * 书id
     */
    private Integer bookId;
    /**
     * 读者id
     */
    private Integer readerId;
    /**
     * 借书卡
     */
    private String readerNumber;
    /**
     * 图书名称
     */
    private String name;
    /**
     * 归还类型
     */
    private String backType;
    /**
     * 图书类型
     */
    private String status;
    /**
     *借出时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lendDate;

    /**
     *还书时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date backDate;

    private String exceptRemarks;
    public LendBook() {
    }

    public LendBook(Integer id, Integer bookId, Integer readerId, String readerNumber, String name, String backType, String status, Date lendDate, Date backDate, String exceptRemarks) {
        this.id = id;
        this.bookId = bookId;
        this.readerId = readerId;
        this.readerNumber = readerNumber;
        this.name = name;
        this.backType = backType;
        this.status = status;
        this.lendDate = lendDate;
        this.backDate = backDate;
        this.exceptRemarks = exceptRemarks;
    }

    public String getExceptRemarks() {
        return exceptRemarks;
    }

    public void setExceptRemarks(String exceptRemarks) {
        this.exceptRemarks = exceptRemarks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public String getReaderNumber() {
        return readerNumber;
    }

    public void setReaderNumber(String readerNumber) {
        this.readerNumber = readerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackType() {
        return backType;
    }

    public void setBackType(String backType) {
        this.backType = backType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LendBook{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", readerNumber='" + readerNumber + '\'' +
                ", name='" + name + '\'' +
                ", backType='" + backType + '\'' +
                ", status='" + status + '\'' +
                ", lendDate=" + lendDate +
                ", backDate=" + backDate +
                ", exceptRemarks='" + exceptRemarks + '\'' +
                '}';
    }
}
