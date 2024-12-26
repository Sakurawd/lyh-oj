package com.yupi.lyhoj.judge.codesandbox;

import com.yupi.lyhoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.lyhoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @Author: Sakura
 * @Date: 2024/12/16 12:31
 * @Version: v1.0.0
 * @Description: TODO
 **/
/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
