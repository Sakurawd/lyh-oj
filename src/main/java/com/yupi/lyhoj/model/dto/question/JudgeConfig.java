package com.yupi.lyhoj.model.dto.question;

import lombok.Data;

/**
 * @Author: Sakura
 * @Date: 2024/11/17 21:44
 * @Version: v1.0.0
 * @Description: TODO
 * 题目判题配置
 **/
@Data
public class JudgeConfig {

    /**
     * 时间限制（ms）
     */
    private Long timeLimit;

    /**
     * 空间限制（kb）
     */
    private Long memoryLimit;

    /**
     * 堆栈限制（kb）
     */
    private Long stackLimit;
}
