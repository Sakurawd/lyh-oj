package com.yupi.lyhoj.model.dto.questionsubmit;

import lombok.Data;

/**
 * @Author: Sakura
 * @Date: 2024/11/17 21:44
 * @Version: v1.0.0
 * @Description: 题目用例
 **/
@Data
public class JudgeInfo {

     /**
     * 程序执行信息
     */
    private String message;

    /**
     * 消耗内存
     */
    private Long memory  ;

    /**
     * 消耗的时间（kb）
     */
    private Long time;
}
