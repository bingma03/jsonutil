//******************************************************************************
// 版权所有(c) 2017，科大国创软件股份有限公司，保留所有权利。
//******************************************************************************

package json.util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import json.processors.JsonValueDateProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * JSON工具类.
 * @author mabing
 */
public class JSONUtil {
    
    /**
     * 将JSON字符串转成JSON对象.
     * 
     * @param str JSON字符串，如{"name":"mabing"}
     * @return JSON对象
     */
    public static JSONObject strToJsonObject(String str) {
        return JSONObject.fromObject(str);
    }
    
    /**
     * 将Map转成JSON对象.
     * @param <T>
     * 
     * @param map 键值对
     * @return JSON对象
     */
    public static <T> JSONObject mapToJsonObject(Map<String, T> map) {
        return JSONObject.fromObject(map);
    }
    
    /**
     * 将对象转成JSON对象.
     * 
     * @param obj 对象
     * @return JSON对象
     */
    public static JSONObject objToJsonObject(Object object) {
        return JSONObject.fromObject(object);
    }
    
    /**
     * 字符串转成JSON数组.
     * 
     * @param str JSON字符串
     * @return JSON数组
     */
    public static JSONArray strToJsonArray(String str) {
        return JSONArray.fromObject(str);
    }
    
    /**
     * List转成JSON数组.
     * @param <T>
     * 
     * @param list List集合
     * @return JSON数组
     */
    public static <T> JSONArray listToJsonArray(List<T> list) {
        return JSONArray.fromObject(list);
    }
    
    /**
     * 将对象转成JSON数组.
     * 
     * @param str JSON字符串
     * @return JSON数组
     */
    public static JSONArray objToJsonArray(Object object) {
        return JSONArray.fromObject(object);
    }
    
    /**
     * 将对象转成传入类型的List.
     * 
     * @param obj 对象 e.g. ["zhangsan","lisi"]
     * @param objClass  传入类型
     * @return 传入类型的List
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> getListFromObject(Object object, Class<T> objClass) {
        JSONArray array = JSONArray.fromObject(object);
        return (List<T>) JSONArray.toCollection(array, objClass);
    }
    
    /**
     * 将JSON数组转成传入类型的List.
     * 
     * @param array JSON数组  e.g. ["zhangsan","lisi"]
     * @param objClass  传入类型
     * @return 传入类型的List
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> getListFromArray(JSONArray array, Class<T> objClass) {
        return (List<T>) JSONArray.toCollection(array, objClass);
    }
    
    /**
     * 对象转成传入类型的map，map中键对应的是各种类型的值（String，Integer）.
     * 
     * @param obj String或者对象   e.g. {"name":"mabing","age":"23"}    
     * @param objClass 传入类型
     * @return 传入类型对应的Map
     */
    @SuppressWarnings("unchecked")
    public static <T> Map<String, T> getStrMapFromObject(Object object, Class<T> objClass){
        String key = "";
        T value;
        Map<String, T> map  = new HashMap<>();
        JSONObject jsonObject = JSONObject.fromObject(object);
        Iterator<String> iterator = jsonObject.keys();
        while (iterator.hasNext()) {
            key = iterator.next();
            value = (T) jsonObject.get(key);
            map.put(key, value);
        }
        return map;
    }
    
    /**
     * 将对象转成传入类型Map，Map中存放的是bean，主要用于处理页面传过来的JSON字符串.
     * 
     * @param obj String或者对象    e.g. {"person1":{"name":"mabing","age":"13"}}
     * @param objClass  传入类型（Bean）
     * @return 存放Bean的Map对象
     */
    @SuppressWarnings("unchecked")
    public static <T> Map<String, T> getBeanMapFromObject(Object object, Class<T> objClass) {
        String key = "";
        T value;
        Map<String, T> map = new HashMap<>();
        JSONObject jsonObject = JSONObject.fromObject(object);
        Iterator<String> iterator = jsonObject.keys();
        while (iterator.hasNext()) {
            key = iterator.next();
            value = (T) JSONObject.toBean((JSONObject) jsonObject.get(key), objClass);
            map.put(key, value);
        }
        return map;
    }
    
    /**
     * 将对象转成传入类型List，List中保存的是Bean.
     * 
     * @param obj e.g. [{"name":"mabing"},{"name":"liuqun"}]
     * @param objClass Class---Bean
     * @return 传入类型对应的List
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> getBeanListFromObject(Object object, Class<T> objClass) {
        JSONArray array = JSONArray.fromObject(object);
        List<T> list = new ArrayList<>();
        for (int i = 0; i < array.size(); i ++) {
            list.add((T) JSONObject.toBean((JSONObject) array.get(i), objClass));
        }
        return list;
    }
    
    /**
     * 将对象转成传入类型List，List中保存的是String、Integer等类型的数据.
     * 
     * @param obj e.g. ["mabing","liuqun"]
     * @param objClass Class---String、Integer等类型
     * @return 传入类型对应的List
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> getListFromObjectSelf(Object object, Class<T> objClass) {
        JSONArray array = JSONArray.fromObject(object);
        List<T> list = new ArrayList<>();
        for (int i = 0; i < array.size(); i ++) {
            list.add((T) array.get(i));
        }
        return list;
    }
    
    /**
     * 将对象通过注册的时间处理器转成JSON对象.
     * 
     * @param object 对象
     * @param pattern 时间格式
     * @return JSON对象
     */
    public static String getJsonObjectFromObject(Object object, String pattern) {
        JsonConfig config = new JsonConfig();
        config.registerJsonValueProcessor(Date.class, new JsonValueDateProcessor(pattern));
        return JSONObject.fromObject(object, config).toString();
    }
}
