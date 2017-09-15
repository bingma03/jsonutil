//******************************************************************************
// 版权所有(c) 2017，科大国创软件股份有限公司，保留所有权利。
//******************************************************************************

package json.jsonobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import json.entity.Person;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * JSONObject练习.
 * @author mabing
 */
public class JsonObjectPractice {
    public static JSONObject jsonObject;
    public static JSONArray jsonArray;
    public JsonObjectPractice(){
        if (jsonObject == null) {
            jsonObject = new JSONObject();
            jsonArray = new JSONArray();
        }
    }
    
    /**
     * JsonObject格式输出.
     */
    public void getJsonFormat(){
        jsonObject.clear();
        jsonObject.put("name", "mabing");
        jsonObject.put("age", "23");
        System.out.println(jsonObject.toString());
    }
    
    /**
     * accumulate函数.
     */
    public void jsonAccumulate(){
        System.out.println("----------------------------------------------");
        System.out.println("accumulate函数：");
        jsonObject.clear();
        jsonObject.accumulate("name", jsonArray);
        jsonObject.accumulate("name", "马冰");
        jsonObject.accumulate("name", "刘群");
        System.out.println(jsonObject.toString());
    }
    
    /**
     * compareTo函数--比较两个JsonObject的长度大小，-1、0、1分别代表小于、等于和大于.
     */
    public void jsonCompareTo(){
        System.out.println("----------------------------------------------");
        System.out.println("compareTo函数：");
        jsonObject.clear();
        JSONObject obj = new JSONObject();
        jsonObject.accumulate("name", "马冰");
        jsonObject.accumulate("name1", "刘群");
        obj.accumulate("name", "马冰");
        obj.accumulate("name", "刘群");
        int i = jsonObject.compareTo(obj);
        System.out.println(i);
    }
    
    /**
     * containsValue函数.
     */
    public void jsonContainsValue(){
        System.out.println("----------------------------------------------");
        System.out.println("containsValue函数：");
        jsonObject.clear();
        jsonObject.accumulate("name", "马冰")
                  .accumulate("name", "刘群");
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.containsValue("刘群"));
    }
    
    /**
     * put函数--存放Collection-自动转成JsonObject或者JsonArray
     */
    public void jsonPut(){
        System.out.println("----------------------------------------------");
        System.out.println("put函数：");
        
        List<JSONObject> list = new ArrayList<>();
        JSONObject obj1 = new JSONObject();
        JSONObject obj2 = new JSONObject();
        obj1.put("name", "马冰");
        obj2.put("name", "刘群");
        list.add(obj1);
        list.add(obj2);
        
        Map<String, String> map = new HashMap<>();
        map.put("name", "流向");
        map.put("age", "30");
        
        jsonObject.clear();
        jsonObject.put("name", list);
        jsonObject.put("信息", map);
        
        System.out.println(jsonObject.toString());
    }
    
    /**
     * JsonToBean.
     */
    public void jsonToBean(){
        System.out.println("----------------------------------------------");
        System.out.println("JsonToBean：");
        jsonObject.clear();
        jsonObject.put("name", "马冰");
        jsonObject.put("age", "23");
        
        Person person = (Person)JSONObject.toBean(jsonObject, Person.class);
        System.out.println("name：" + person.getName());
        System.out.println("age：" + person.getAge());
    }
    
    /**
     * toJSONArray.
     */
    public void jsonToJSONArray(){
        System.out.println("----------------------------------------------");
        System.out.println("toJSONArray：");
        jsonObject.clear();
        jsonObject.accumulate("name", "马冰");
        jsonObject.accumulate("name", "刘群");
        jsonObject.accumulate("age", "23");
        
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.toJSONArray(jsonObject.names()));
    }
    /**
     * optJSONArray.
     */
    public void jsonOptJSONArray(){
        System.out.println("----------------------------------------------");
        System.out.println("toJSONArray：");
        jsonObject.clear();
        jsonObject.accumulate("name", "马冰");
        jsonObject.accumulate("name", "刘群");
        jsonObject.accumulate("age", "23");
        
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.optJSONArray("name"));
    }
    
    /**
     * fromObject.
     */
    public void jsonFromObject(){
        System.out.println("----------------------------------------------");
        System.out.println("fromObject：");
        
        JSONObject object = new JSONObject();
        Person person = new Person();
        person.setName("mabing");
        person.setAge("12");
        object = JSONObject.fromObject(person);
        System.out.println(object.toString());
    }
}
