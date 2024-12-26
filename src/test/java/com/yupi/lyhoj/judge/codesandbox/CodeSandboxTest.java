package com.yupi.lyhoj.judge.codesandbox;


import com.yupi.lyhoj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.yupi.lyhoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.lyhoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.yupi.lyhoj.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Sakura
 * @Date: 2024/12/16 13:14
 * @Version: v1.0.0
 * @Description: TODO
 **/
@SpringBootTest
class CodeSandboxTest { 
    
    
    @Value("${codesandbox.type:example}")
    private String type;

    @Test
    void executeCode() {
        CodeSandbox CodeSandbox = new ExampleCodeSandbox();
        String code = " int main(){}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .inputList(inputList)
                .code(code)
                .language(language)
                .build();
        ExecuteCodeResponse executeCodeResponse = CodeSandbox.executeCode(executeCodeRequest);
//        Assertions.assertNotNull(executeCodeResponse); // 添加断言以验证返回值
    }

    @Test
    void executeCodeByValue() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        String code = "int main() { }";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
//        Assertions.assertNotNull(executeCodeResponse);
    }
    @Test
    void executeCodeByProxy() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String code = "int main() { }";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String type = scanner.next();
            CodeSandbox CodeSandbox = CodeSandboxFactory.newInstance(type);
            String code = " int main(){}";
            String language = QuestionSubmitLanguageEnum.JAVA.getValue();
            List<String> inputList = Arrays.asList("1 2", "3 4");
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .inputList(inputList)
                    .code(code)
                    .language(language)
                    .build();
            ExecuteCodeResponse executeCodeResponse = CodeSandbox.executeCode(executeCodeRequest);
        }
    }
}