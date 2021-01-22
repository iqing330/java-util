/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package markdown;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * markdown 工具
 *
 * @author aiqing.wyx
 * @version MarkdownUtil.java, v 0.1 2021年01月22日 7:42 下午 wangyuxiang Exp $
 */
public class MarkdownUtil {

    private static final String SEP_ROW = " ----- |";
    private static final String SEP     = "|";
    private static final String BLANK   = "";

    public static <T> String convertTable(List<T> list, Class<T> clazz) {
        Field[] fields = clazz.getFields();

        if (fields.length == 0) {
            fields = clazz.getDeclaredFields();
        }

        List<Field> fieldList = new ArrayList<>(Arrays.asList(fields));

        fieldList.removeIf(e -> getAnnotation(e) == null);
        fieldList.sort(Comparator.comparingInt(e -> getAnnotation(e).order()));

        StringBuilder markdown = new StringBuilder();
        markdown.append(initTableHead(fieldList));
        markdown.append(initSepRow(fieldList.size()));
        list.forEach(e -> {
            StringBuilder row = new StringBuilder(SEP);
            fieldList.forEach(field -> {
                try {
                    Object object = fieldGetMethod(field, clazz).invoke(e);
                    row.append(object == null ? BLANK : object).append(SEP);
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                    throw new RuntimeException(ex);
                }
            });
            row.append("\n");
            markdown.append(row);
        });
        return markdown.toString();
    }

    private static String initTableHead(List<Field> fieldList) {
        StringBuilder builder = new StringBuilder(SEP);
        fieldList.forEach(e -> builder.append(getAnnotation(e).header()).append(SEP));
        builder.append("\n");
        return builder.toString();
    }

    private static String initSepRow(int size) {
        StringBuilder builder = new StringBuilder(SEP);
        for (int i = 0; i < size; i++) {
            builder.append(SEP_ROW);
        }
        builder.append("\n");
        return builder.toString();
    }

    private static Description getAnnotation(Field field) {
        return field.getAnnotation(Description.class);
    }

    private static Method fieldGetMethod(Field field, Class clazz) throws NoSuchMethodException {

        String fieldName = field.getName();

        char[] cs = fieldName.toCharArray();

        cs[0] -= 32;

        String methodName = "get" +  String.valueOf(cs);

        return clazz.getMethod(methodName);
    }

}

