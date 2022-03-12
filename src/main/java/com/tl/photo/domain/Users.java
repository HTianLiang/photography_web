package com.tl.photo.domain;

import java.io.Serializable;

/**
 * @Author tl
 * @Date 2021/10/15 9:43 上午
 * @Version 1.0
 * @Description 用户实体类
 */
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username; //账号
    private String password; //密码
    private String avatarPic; //头像
    private String name; //姓名
    private Integer sex; //性别 女-0 男-1
    private Integer age; //年龄
    private String origin; //籍贯
    private String nationality; //民族
    private String phone; //电话
    private String city; //城市
    private String email; //电子邮件
    private String createTime; //注册时间
    // 接收前台验证码
    private String verifyCode;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarPic() {
        return avatarPic;
    }

    public void setAvatarPic(String avatarPic) {
        this.avatarPic = avatarPic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatarPic='" + avatarPic + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", origin='" + origin + '\'' +
                ", nationality='" + nationality + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", createTime='" + createTime + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
