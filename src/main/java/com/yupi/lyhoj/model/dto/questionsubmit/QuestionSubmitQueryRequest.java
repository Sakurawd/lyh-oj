package com.yupi.lyhoj.model.dto.questionsubmit;

import com.yupi.lyhoj.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author: Sakura
 * @Date: 2024/11/19 17:37
 * @Version: v1.0.0
 * @Description: 查询请求
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    /**
     * 编程语言
     */
    private String language;

    /**
     * 提交状态
     */
    private Integer status;

    /**
     * 题目 id
     */
    private Long questionId;


    /**
     * 用户 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}
