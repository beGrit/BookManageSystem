package org.pocky.demo.tests;

import org.junit.jupiter.api.Test;
import org.pocky.demo.models.Person;
import com.alibaba.fastjson.JSON;

public class testFastjson {
    @Test
    public void test1() {
        Person person = PersonFactory.getInstance();
        String json = JSON.toJSONString(person);
        System.out.println(json);
    }

    @Test
    public void test2() {
        String json2 = "{\"bookList\":[{\"author\":\"\",\"bname\":\"\",\"bno\":\"b01\",\"bookNumber\":1,\"isValid\":1,\"price\":0,\"publish\":\"\"},{\"author\":\"\",\"bname\":\"\",\"bno\":\"b02\",\"bookNumber\":1,\"isValid\":1,\"price\":0,\"publish\":\"\"},{\"author\":\"\",\"bname\":\"\",\"bno\":\"b03\",\"bookNumber\":1,\"isValid\":1,\"price\":0,\"publish\":\"\"}],\"map\":{\"k1\":\"v1\",\"k2\":\"v2\"},\"name\":\"lsf\"}\n";
        Person person2 = JSON.parseObject(json2, Person.class);
        System.out.println(person2);
    }
}
