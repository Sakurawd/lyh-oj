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
        String code = "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        int a = Integer.parseInt(args[0]);\n" +
                "        int b = Integer.parseInt(args[1]);\n" +
                "        System.out.println(\"结果:\" + (a + b));\n" +
                "    }\n" +
                "}\n";
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

        String code = "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        int a = Integer.parseInt(args[0]);\n" +
                "        int b = Integer.parseInt(args[1]);\n" +
                "        System.out.println(\"结果:\" + (a + b));\n" +
                "    }\n" +
                "}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");

        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();

        try {
            ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
            System.out.println("Received response: " + executeCodeResponse); // 或者使用日志记录
            Assertions.assertNotNull(executeCodeResponse);
        } catch (RuntimeException e) {
            System.err.println("Caught an exception while executing code: " + e.getMessage());
            throw e; // 或者根据需要处理异常
        }
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