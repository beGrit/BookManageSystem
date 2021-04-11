package org.pocky.demo.utils;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * 对象转换器工具
 */
public class RequestDataUtil {
    static {
        ConvertUtils.register(new Converter() {
            @Override
            public Date convert(Class aClass, Object o) {
                if (o == null) {
                    return null;
                }
                if (aClass == Date.class) {
                    String pattern = "yyyy-MM-dd HH:mm:ss";
                    DateFormat format = new SimpleDateFormat(pattern);
                    if (o instanceof String) {
                        String dateStr = (String) o;
                        try {
                            if (aClass == Timestamp.class) {
                                return new Timestamp(new Date().getTime());
                            }
                            Date d = format.parse(dateStr);
                            return d;
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                new Date();
                return null;
            }
        }, Date.class);
    }
}
