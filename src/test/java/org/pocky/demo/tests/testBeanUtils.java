package org.pocky.demo.tests;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.jupiter.api.Test;
import org.pocky.demo.models.Book;
import org.pocky.demo.models.Person;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class testBeanUtils {
    @Test
    public void test() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Person person = PersonFactory.getInstance();

        String name = (String) PropertyUtils.getProperty(person, "name");

        Book b_rtn1 = (Book) PropertyUtils.getIndexedProperty(person, "bookList", 0);
        Book b_rtn2 = (Book) PropertyUtils.getIndexedProperty(person, "bookList[1]");

        String m_rtn1 = (String) PropertyUtils.getMappedProperty(person, "map", "k1");
        String m_rtn2 = (String) PropertyUtils.getMappedProperty(person, "map", "k2");

        String n_rtn1 = (String) PropertyUtils.getNestedProperty(person, "place()");

        System.out.println(name);
        System.out.println(b_rtn1);
        System.out.println(b_rtn2);
        System.out.println(m_rtn1);
        System.out.println(m_rtn2);
        System.out.println(n_rtn1);

    }

    @Test
    public void test2() throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "lsf");
        Person person = new Person();
        BeanUtils.populate(person, map);
        System.out.println(person);
    }
}
