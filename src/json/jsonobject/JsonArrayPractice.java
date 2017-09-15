package json.jsonobject;

import java.util.ArrayList;
import java.util.List;

import json.entity.Person;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

public class JsonArrayPractice {
    private static JSONArray jsonArray = null;
    public JsonArrayPractice(){
        if (jsonArray == null) {
            jsonArray = new JSONArray();
        } 
    }
    
    /**
     * JsonArray格式.
     */
    public void arrayFormat(){
        System.out.println("----------------------------------------------");
        System.out.println("JsonArray格式：");
        jsonArray.clear();
        jsonArray.add("mabing");
        jsonArray.add("mabing");
        jsonArray.add("liuqun");
        jsonArray.add("mabing");
        System.out.println(jsonArray.toString());
        
    }
    
    /**
     * discard方法.
     */
    public void arrayDiscard(){
        System.out.println("----------------------------------------------");
        System.out.println("discard方法：");
        
        System.out.println(jsonArray.discard("mabing").toString());
        System.out.println(jsonArray.discard(1).toString());
    }
    
    /**
     * remove方法.
     */
    public void arrayRemove(){
        System.out.println("----------------------------------------------");
        System.out.println("remove方法：");
        
        jsonArray.clear();
        jsonArray.add("mabing");
        jsonArray.add("mabing");
        jsonArray.add("liuqun");
        jsonArray.add("mabing");
        System.out.println("删除前：" + jsonArray.toString());
        jsonArray.remove("mabing");
        System.out.println("删除之后：" + jsonArray.toString());
    }
    /**
     * removeAll方法.
     */
    public void arrayRemoveAll(){
        System.out.println("----------------------------------------------");
        System.out.println("removeAll方法：");
        
        jsonArray.clear();
        jsonArray.add("mabing");
        jsonArray.add("mabing");
        jsonArray.add("liuqun");
        jsonArray.add("mabing");
        
        List<String> list = new ArrayList<>();
        list.add("mabing");
        System.out.println("删除前：" + jsonArray.toString());
        jsonArray.removeAll(list);
        System.out.println("删除之后：" + jsonArray.toString());
    }
    
    /**
     * fromObject方法.
     */
    public void arrayFromObject(){
        System.out.println("----------------------------------------------");
        System.out.println("fromObject方法：");
        
        JSONArray array = new JSONArray();
        
        Person person = new Person();
        person.setName("mabing");
        person.setAge("12");
        
        array = JSONArray.fromObject(person);
        System.out.println("对象转成JsonArray：" + array.toString());
        System.out.println("获取index对应的字符串：" + array.getString(0));
    }
    
    /**
     * join方法--创建字符串.
     */
    public void arrayJoin(){
        System.out.println("----------------------------------------------");
        System.out.println("join方法：");
        
        jsonArray.clear();
        jsonArray.add("mabing");
        jsonArray.add("mabing");
        jsonArray.add("liuqun");
        jsonArray.add("mabing");
        System.out.println("join之前：" + jsonArray.toString());
        System.out.println("join之后：" + jsonArray.join(","));
        System.out.println("join并去掉引号：" + jsonArray.join(",",true));
    }
    
    /**
     * toArray方法.
     */
    public void arrayToArray(){
        System.out.println("----------------------------------------------");
        System.out.println("toArray方法：");
        
        JSONObject object = new JSONObject();
        object.put("name", "mabing");
        object.put("age", "12");
        
        jsonArray.clear();
        jsonArray.add("liuqun");
        jsonArray.add(object);
        
        JSONObject obj = (JSONObject) jsonArray.toArray()[1];
        System.out.println(obj.toString());
    }
    
    /**
     * toArray方法.
     */
    public void arrayToArray1(){
        System.out.println("----------------------------------------------");
        System.out.println("toArray1方法：");
        
        JSONObject object = new JSONObject();
        object.put("name", "mabing");
        object.put("age", "12");
        
        jsonArray.clear();
        jsonArray.add(object);
        
        JSONObject obj = (JSONObject)jsonArray.toArray()[0];
        Person person = (Person) JSONObject.toBean(obj, Person.class);
        System.out.println(person.getName());
    }
    
}
