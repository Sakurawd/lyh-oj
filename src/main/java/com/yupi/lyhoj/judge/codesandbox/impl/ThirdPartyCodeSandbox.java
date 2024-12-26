package com.yupi.lyhoj.judge.codesandbox.impl;

import com.yupi.lyhoj.judge.codesandbox.CodeSandbox;
import com.yupi.lyhoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.lyhoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @Author: Sakura
 * @Date: 2024/12/16 13:12
 * @Version: v1.0.0
 * @Description: TODO
 * 第三方的代码沙箱
 **/
public class ThirdPartyCodeSandbox implements CodeSandbox {
    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方的代码沙箱");
        return null;
    }
}
