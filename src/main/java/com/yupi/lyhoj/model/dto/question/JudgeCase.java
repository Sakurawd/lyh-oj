package com.yupi.lyhoj.model.dto.question;

import lombok.Data;

/**
 * @Author: Sakura
 * @Date: 2024/11/17 21:44
 * @Version: v1.0.0
 * @Description: TODO
 * 题目用例
 **/
@Data
public class JudgeCase {
    /**
     * 输入用例
     */
    private String input;

    /**
     * 输出用例
     */
    private String output;
}
