package org.example.properties.isField;

import org.example.JsonConverterUtil;

public class JsonIsFieldProperty {

    public static void main(String[] args) {
        JsonConverterUtil jsonConverter = new JsonConverterUtil();
        DemoClass myObject = new DemoClass("test name", 10, 20);

        // TODO. 将Object转换成的json数据中会包含isField方法的字段, 其值为方法的返回值
        // {"emptyName":false,"name":"test name","value1":10,"value2":20}
        System.out.println(jsonConverter.toJson(myObject));

        // {"emptyName":true,"value1":0,"value2":0}
        System.out.println(jsonConverter.toJson(new DemoClass()));
    }
}
