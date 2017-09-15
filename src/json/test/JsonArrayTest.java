//******************************************************************************
// 版权所有(c) 2017，科大国创软件股份有限公司，保留所有权利。
//******************************************************************************

package json.test;

import json.jsonobject.JsonArrayPractice;

/**
 * JsonArrayTest.
 * @author mabing
 */
public class JsonArrayTest {
    public static void main(String[] args) {
        JsonArrayPractice array = new JsonArrayPractice();
        
        /**
         * JsonArray格式.
         */
        array.arrayFormat();
        
        
        /**
         * discard方法.
         */
        array.arrayDiscard();
        
        /**
         * remove方法.
         */
        array.arrayRemove();
        
        /**
         * removeAll方法.
         */
        array.arrayRemoveAll();
        
        /**
         * fromObject方法.
         */
        array.arrayFromObject();
        
        /**
         * join方法--创建字符串.
         */
        array.arrayJoin();
        
        /**
         * toArray方法.
         */
        array.arrayToArray();
        
        /**
         * toArray1方法.
         */
        array.arrayToArray1();
    }
}
