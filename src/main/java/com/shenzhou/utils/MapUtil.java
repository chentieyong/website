package com.shenzhou.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Create Desc: 字符串实体Map和object转换
 */
public class MapUtil {
    public static <T> T toObject(Map<String, String> param, Class<T> clazz) {
        T requestBase = null;
        try {
            requestBase = JsonUtil.readObject(
                    JsonUtil.writeValueAsString(param),
                    clazz);
        } catch (Exception ex) {
        }
        return requestBase;
    }

    public static <T> T toBean(Map<String, Object> param, Class<T> clazz) {
        T requestBase = null;
        try {
            requestBase = JsonUtil.readObject(
                    JsonUtil.writeValueAsString(param),
                    clazz);
        } catch (Exception ex) {
        }
        return requestBase;
    }

    public static <T> T toObject(Map<String, String> param, Class<T> clazz, Boolean keyToLower) {
        Map<String, String> paramNew = new HashMap<String, String>();
        if (keyToLower) {
            for (Map.Entry<String, String> item : param.entrySet()) {
                paramNew.put(item.getKey().toLowerCase(), item.getValue());
            }
        }
        return toObject(paramNew, clazz);
    }

    public static <T> T toBean(Map<String, Object> param, Class<T> clazz, Boolean keyToLower) {
        Map<String, Object> paramNew = new HashMap<String, Object>();
        if (keyToLower) {
            for (Map.Entry<String, Object> item : param.entrySet()) {
                paramNew.put(item.getKey().toLowerCase(), item.getValue());
            }
        }
        return toBean(paramNew, clazz);
    }

    public static <T> T convertBean(Class<T> clazz, String json) {
        T requestBase = JsonUtil.readObject(json, clazz);
        return requestBase;
    }

    //json2map
    public static Map<String, Object> parseJSON2Map(JSONObject json) {
        Map<String, Object> map = new HashMap<String, Object>();
        //最外层解析
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            //如果内层还是数组的话，继续解析
            if (v instanceof JSONArray) {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Iterator<JSONObject> it = ((JSONArray) v).iterator();
                while (it.hasNext()) {
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }

    public static <T> T convertMap(Class<T> clazz, Map<String, Object> map)
            throws IntrospectionException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz); // 获取类属性
        T obj = clazz.newInstance(); // 创建 JavaBean 对象

        // 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();

            if (map.containsKey(propertyName)) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
                Object value = map.get(propertyName);

                Object[] args = new Object[1];
                args[0] = value;

                descriptor.getWriteMethod().invoke(obj, args);
            }
        }
        return obj;
    }

    public static String mapToJsonStr(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder("{");

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String[] strs = (String[]) entry.getValue();
            if (null == strs || strs.length == 0) {
                continue;
            }
            stringBuilder.append("\"" + entry.getKey() + "\":\"" + strs[0] + "\",");
        }
        String jsonStr = stringBuilder.toString();
        if (jsonStr.endsWith(",")) {
            jsonStr = jsonStr.substring(0, jsonStr.lastIndexOf(","));
        }
        jsonStr += "}";
        return jsonStr;
    }

    public static Map convertBean(Object bean)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Class type = bean.getClass();
        Map returnMap = new HashMap();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, "");
                }
            }
        }
        return returnMap;
    }
}
