package lombok;

// 声明属性的Getter和Setter方法
@Getter
@Setter
public class LombokGetterSetter {

    @Getter
    @Setter(AccessLevel.NONE) // No access to setter method
    private String name;
}