//******************************************************************************
// 版权所有(c) 2017，科大国创软件股份有限公司，保留所有权利。
//******************************************************************************

package json.test;

import json.jsonobject.JsonObjectPractice;

/**
 * 测试
 * @author mabing
 */
public class JsonObjectTest {
    public static void main(String[] args) {
        JsonObjectPractice object = new JsonObjectPractice();
        
        /**
         * JsonObject输出格式.
         */
        object.getJsonFormat();
        
        /**
         * accumulate函数.
         */
        object.jsonAccumulate();
        
        /**
         * compareTo函数.
         */
        object.jsonCompareTo();
        
        /**
         * containsValue函数.
         */
        object.jsonContainsValue();
        
        /**
         * put函数.
         */
        object.jsonPut();
        
        /**
         * jsonToBean.
         */
        object.jsonToBean();
        
        /**
         * jsonToJSONArray.
         */
        object.jsonToJSONArray();
        
        /**
         * toJSONArray.
         */
        object.jsonToJSONArray();
        
        /**
         * fromObject.
         */
        object.jsonFromObject();
    }
}
