package org.pocky.demo.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/***
 * 对象转换器工具
 */
public class RequestDataUtil {
    static {
        ConvertUtils.register(new Converter() {
            @Override
            public <T> T convert(Class<T> aClass, Object o) {
                if (o == null) {
                    return null;
                }
                Date date = null;
                if (aClass == Date.class) {
                    String pattern = "yyyy-MM-dd HH:mm:ss";
                    SimpleDateFormat format = new SimpleDateFormat(pattern);
                    if (o instanceof String) {
                        String dateStr = (String) o;
                        try {
                            date = format.parse(dateStr);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return (T) date;
            }
        }, Date.class);
    }

    public static <T> T parseRequestParamsMap(Map<String, String[]> map, T t) {
        try {
            BeanUtils.populate(t, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }
}
