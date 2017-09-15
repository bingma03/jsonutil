//******************************************************************************
// 版权所有(c) 2017，科大国创软件股份有限公司，保留所有权利。
//******************************************************************************

package json.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import json.entity.Person;
import json.util.JSONUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * JSON工具类的测试类.
 * @author mabing
 */
public class JsonUtilTest {

    public static void main(String[] args) {
        
        JSONObject object = null;
        JSONArray array = null;
        List<String> list = new ArrayList<>();
        
        
        //字符串==>JSON对象
        String jsonStr = "{\"name\":\"mabing\",\"age\":\"20\"}";
        object = JSONUtil.strToJsonObject(jsonStr);
        System.out.println("字符串==>JSON对象：" + object.toString());
        
        //map==>JSON对象
        Map<String, Object> map = new HashMap<>();
        map.put("name", "mabing");
        map.put("sex", "male");
        map.put("age", "20");
        object.clear();
        object = JSONUtil.mapToJsonObject(map);
        System.out.println("map==>JSON对象：" + object.toString());
        
        //list==>JSON数组
        list.clear();
        list.add("dd");
        list.add("gege");
        array = JSONUtil.listToJsonArray(list);
        System.out.println("list==>JSON数组：" + array.toString());
        
        //list==>JSON数组
        List<Person> personList = new ArrayList<>();
        personList.clear();
        Person person = new Person();
        person.setName("mabing");
        person.setAge("23");
        personList.add(person);
        array.clear();
        array = JSONUtil.listToJsonArray(personList);
        System.out.println("list==>JSON数组：" + array.toString());
        
        //对象==>List
        array.clear();
        array.add("dfa");
        array.add("dgefe");
        System.out.println("对象==>List：" + JSONUtil.getListFromArray(array, String.class).toString());
        
        //对象==>Map(Class String)
        object.clear();
        object.put("name", "mabing");
        object.put("age", "23");
        System.out.println("对象==>Map(Class String)：" + JSONUtil.getStrMapFromObject(object, String.class).toString());
        
        //对象==>Map（Class Integer）
        object.clear();
        object.put("size", 10);
        object.put("height", 23);
        Map<String, Integer> map1 = JSONUtil.getStrMapFromObject(object, Integer.class);
        System.out.println("对象==>Map（Class Integer）：" + map1.get("size") * map1.get("height"));
        
        //对象==>Map(Class Bean)---参数为Json对象
        person.setName("mabing");
        person.setAge("23");
        object.clear();
        object.put("person1", person);
        System.out.println("对象==>Map(Class Bean)：" + JSONUtil.getBeanMapFromObject(object, Person.class));
        
        //JSON字符串==>Map(Class Bean)---参数为Json字符串
        jsonStr = "{\"person1\":{\"name\":\"mabing\",\"age\":\"13\"}}";
        person = JSONUtil.getBeanMapFromObject(jsonStr, Person.class).get("person1");
        System.out.println("JSON字符串==>Map(Class Bean)：" + person.getName() + "----" + person.getAge());
        
        //JSON字符串==>List(Class Bean)-----参数为JSON字符串
        jsonStr = "[{\"name\":\"mabing\"},{\"name\":\"liuqun\"}]";
        person = JSONUtil.getBeanListFromObject(jsonStr, Person.class).get(0);
        System.out.println("JSON字符串==>List(Class Bean)：" + person.getName());
        
        //JSON字符串==>List(Class String)-----参数为JSON字符串
        jsonStr = "[\"mabing\",\"liuqun\"]";
        System.out.println("JSON字符串==>List(Class String)：" + JSONUtil.getListFromObjectSelf(jsonStr, String.class));
        
        //对象===>JSON对象(时间处理器)
        Map<String, Object> mapp = new HashMap<>();
        mapp.put("date", new Date());
        mapp.put("name", "mabing");
        System.out.println("对象===>JSON对象(时间处理器)：" + JSONUtil.getJsonObjectFromObject(mapp, "yyyy年MM月dd日 HH时mm分ss秒"));
        
    }

}
