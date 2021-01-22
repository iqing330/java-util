/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package markdown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aiqing.wyx
 * @version MarkdownUtilTest.java, v 0.1 2021年01月22日 8:07 下午 wangyuxiang Exp $
 */
public class MarkdownUtilTest {

    public static void main(String[] args) {

        Student student1 = new Student(1,"张三","男", 28, "游泳");
        Student student2 = new Student(2,"李四","男", 19, "足球");
        Student student3 = new Student(3,"王阿丽","女", 43, "瑜伽");
        Student student4 = new Student(4,"小莹","女", 23, "瑜伽");
        Student student5 = new Student(5,"张三","男", 54, "游泳");
        Student student6 = new Student(6,"张三","男", 13, "游泳");
        Student student7 = new Student(7,"张三","男", 44, "游泳");

        List<Student> students = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5, student6, student7));

        String md = MarkdownUtil.convertTable(students, Student.class);

        System.out.println(md);

    }
}