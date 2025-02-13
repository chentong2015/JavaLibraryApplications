package jcommander;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

// 验证提供的原始密码是否符合规范
public class EncryptValidator implements IParameterValidator {

    @Override
    public void validate(String param, String arg) {
        if (arg.isEmpty()) {
            throw new ParameterException("Empty original password");
        }
    }
}
