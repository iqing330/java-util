/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package markdown;

/**
 * @author aiqing.wyx
 * @version Student.java, v 0.1 2021年01月22日 8:08 下午 wangyuxiang Exp $
 */
public class Student {

    @Description(header = "学号", order = 1)
    private int number;

    @Description(header = "姓名", order = 2)
    private String name;

    @Description(header = "性别", order = 3)
    private String sex;

    @Description(header = "年龄", order = 4)
    private int age;

    @Description(header = "爱好", order = 5)
    private String hobby;

    public Student() {
    }

    public Student(int number, String name, String sex, int age, String hobby) {
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.hobby = hobby;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}