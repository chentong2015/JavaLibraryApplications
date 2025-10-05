package lombok;

import java.time.LocalDate;

// 声明标准的POJO类型, 等效于添加如下注解
// @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.
@Data
public class LombokData {

    private int id;
    private String title;
    private String details;
    private LocalDate deadline;

    // TODO. 注意is字段Getter和Setter方法的特殊性
    private boolean isChecked;

    public static void main(String[] args) {
        LombokData lombokData = new LombokData();
        lombokData.isChecked();
        lombokData.setChecked(true);
    }
}
