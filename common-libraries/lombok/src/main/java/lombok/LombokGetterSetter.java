package lombok;

// 声明所有属性的Getter和Setter方法
// @Getter
// @Setter
public class LombokGetterSetter {

    // 等效于创建Setter方法
    // public void setFoo(int foo) {
    //   this.foo = foo;
    // }
    @Setter
    private int foo;

    // 设置AccessLevel方法的可访问性, 等效于没有Setter
    @Getter
    @Setter(AccessLevel.NONE)
    private String name;

    // TODO. 如何自定义的Setter存在, 则不会再生成
    @Getter
    @Setter
    private String value;

    public void setValue(String value) {
        this.value = "Value = " + value;
    }

    public static void main(String[] args) {
        LombokGetterSetter lombokGetterSetter = new LombokGetterSetter();
        lombokGetterSetter.setValue("test");
        System.out.println(lombokGetterSetter.getValue());
    }
}