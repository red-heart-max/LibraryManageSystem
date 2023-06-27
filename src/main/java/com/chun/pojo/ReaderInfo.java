package com.chun.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class ReaderInfo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_info.id
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_info.username
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_info.password
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_info.number
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_info.real_name
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    private String realName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_info.sex
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_info.birthday
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_info.address
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_info.tel
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    private String tel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_info.email
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_info.register_date
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    private Date registerDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reader_info.reader_number
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    private String readerNumber;
    /**
     * 人脸
     */
    private String userFaceBase64;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table reader_info
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    private static final long serialVersionUID = 1L;

    public ReaderInfo() {
    }

    public ReaderInfo(Integer id, String username, String password, String realName, String sex, Date birthday, String address, String tel, String email, Date registerDate, String readerNumber, String userFaceBase64) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.registerDate = registerDate;
        this.readerNumber = readerNumber;
        this.userFaceBase64 = userFaceBase64;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_info.id
     *
     * @return the value of reader_info.id
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_info.id
     *
     * @param id the value for reader_info.id
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_info.username
     *
     * @return the value of reader_info.username
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_info.username
     *
     * @param username the value for reader_info.username
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_info.password
     *
     * @return the value of reader_info.password
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_info.password
     *
     * @param password the value for reader_info.password
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_info.real_name
     *
     * @return the value of reader_info.real_name
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_info.real_name
     *
     * @param realName the value for reader_info.real_name
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_info.sex
     *
     * @return the value of reader_info.sex
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_info.sex
     *
     * @param sex the value for reader_info.sex
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_info.birthday
     *
     * @return the value of reader_info.birthday
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_info.birthday
     *
     * @param birthday the value for reader_info.birthday
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_info.address
     *
     * @return the value of reader_info.address
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_info.address
     *
     * @param address the value for reader_info.address
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_info.tel
     *
     * @return the value of reader_info.tel
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_info.tel
     *
     * @param tel the value for reader_info.tel
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_info.email
     *
     * @return the value of reader_info.email
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_info.email
     *
     * @param email the value for reader_info.email
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_info.register_date
     *
     * @return the value of reader_info.register_date
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_info.register_date
     *
     * @param registerDate the value for reader_info.register_date
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reader_info.reader_number
     *
     * @return the value of reader_info.reader_number
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public String getReaderNumber() {
        return readerNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reader_info.reader_number
     *
     * @param readerNumber the value for reader_info.reader_number
     *
     * @mbggenerated Tue Mar 30 16:30:04 CST 2021
     */
    public void setReaderNumber(String readerNumber) {
        this.readerNumber = readerNumber == null ? null : readerNumber.trim();
    }

    public String getUserFaceBase64() {
        return userFaceBase64;
    }

    public void setUserFaceBase64(String userFaceBase64) {
        this.userFaceBase64 = userFaceBase64;
    }

    @Override
    public String toString() {
        return "ReaderInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", readerNumber='" + readerNumber + '\'' +
                ", userFaceBase64='" + userFaceBase64 + '\'' +
                '}';
    }
}