package com.yupi.lyhoj.judge.codesandbox;

import com.yupi.lyhoj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.yupi.lyhoj.judge.codesandbox.impl.RemoteCodeSandbox;
import com.yupi.lyhoj.judge.codesandbox.impl.ThirdPartyCodeSandbox;
/**
 * @Author: Sakura
 * @Date: 2024/12/16 13:43
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class CodeSandboxFactory {

    /**
     * 根据传入类型获取对应的沙箱实例
     * @param type
     * @return
     */
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }

}
