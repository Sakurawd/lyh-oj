package com.yupi.lyhoj.model.dto.questionsubmit;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Sakura
 * @Date: 2024/11/17 21:50
 * @Version: v1.0.0
 * @Description: 创建请求
 **/
@Data
public class QuestionSubmitAddRequest implements Serializable {

    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户代码
     */
    private String code;

    /**
     * 题目 id
     */
    private Long questionId;

    /**
     * 创建用户 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}