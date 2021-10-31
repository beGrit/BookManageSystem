package org.pocky.demo.tests;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class testJedis {
    @Test
    public void test1() {
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.ping());
        jedis.set("foo", "101");
        Map<String, String> map = new HashMap<String, String>();
        map.put("foo", "0001");
        map.put("foo2", "0002");
        jedis.hmset("map1", map);
        System.out.println(jedis.get("foo"));
    }
}
