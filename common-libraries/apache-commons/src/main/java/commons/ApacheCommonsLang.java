package commons;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class ApacheCommonsLang {

    // TODO. StringUtils提供常见的String处理的APIs
    public static void main(String[] args) {
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.upperCase("test"));

        // 移除字符串头部和尾部的空格Whitespace
        // str = stripStart(str, stripChars);
        // str = stripEnd(str, stripChars);
        StringUtils.stripToEmpty("abc ");
    }

    // TODO. SerializationUtils: 对象的序列化和反序列化
    public void testSerializationUtils() {
        User user = new User(1, "test");
        byte[] data = SerializationUtils.serialize(user);
        User deserializedUser = SerializationUtils.deserialize(data);
        System.out.println(deserializedUser);
    }

    class User implements Serializable {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
