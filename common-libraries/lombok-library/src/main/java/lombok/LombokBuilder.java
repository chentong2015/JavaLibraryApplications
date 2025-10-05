package lombok;

// 为类型注入builder设计模式
@Builder
public class LombokBuilder {

    private int id;
    private String name;

    public static void main(String[] args) {
        LombokBuilder builder = LombokBuilder.builder()
                .id(1)
                .name("test")
                .build();
    }
}
