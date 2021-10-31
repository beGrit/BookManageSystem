package org.pocky.demo.factory;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class JsonDeSerializer {
    static {
        /*注册日期类型转换器
         * ConvertUtils.register(Converter converter, Class<?> clazz)
         *   参数1：转换器对象
         *   参数2：要转换的类型
         * */
        ConvertUtils.register(new Converter() {
            @Override
            public <T> T convert(Class<T> aClass, Object o) {
                if (o == null || "".equals(o))
                    return null;
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date parse = null;
                try {
                    parse = format.parse((String)o);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return (T)parse;
            }
        }, Date.class);
    }

    public static <T> T deSerialize(HttpServletRequest request, T t){
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(t,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }
}
