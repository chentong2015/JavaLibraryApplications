package org.example;

public class JsonConverterDemo {

    public static void main(String[] args) {
        JsonConverterUtil jsonConverter = JsonConverterUtil.getInstance();
        DemoObject myObject = new DemoObject("test name", 10, 20);

        // {"emptyName":false,"name":"test name","value1":10,"value2":20}
        System.out.println(jsonConverter.toJson(myObject));

        // {"emptyName":true,"value1":0,"value2":0}
        System.out.println(jsonConverter.toJson(new DemoObject()));
    }

    static class DemoObject {
        private String name; // 默认值为null, 将会被忽略
        private int value1; // 默认值为0, 不会被忽略
        private int value2;

        public DemoObject() {
        }

        public DemoObject(String name, int value1, int value2) {
            this.name = name;
            this.value1 = value1;
            this.value2 = value2;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue1() {
            return value1;
        }

        public void setValue1(int value1) {
            this.value1 = value1;
        }

        public int getValue2() {
            return value2;
        }

        public void setValue2(int value2) {
            this.value2 = value2;
        }

        // TODO. JSON Mapper会默认对is方法的名称视为一个属性, 并生成到JSON中
        public boolean isEmptyName() {
            return this.name == null;
        }

        // TODO. JSON Mapper不会处理该实例方法
        public boolean hasName() {
            return this.name != null;
        }
    }
}