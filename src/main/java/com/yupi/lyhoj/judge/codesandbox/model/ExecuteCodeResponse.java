package com.yupi.lyhoj.judge.codesandbox.model;

import com.yupi.lyhoj.model.dto.questionsubmit.JudgeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Sakura
 * @Date: 2024/12/16 12:45
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteCodeResponse {

    private List<String> outputList;

    /**
     * 接口信息
     */
    private String Message;

    /**
     * 执行状态
     */
    private Integer Status;

    /**
     * 判题信息
     */
    private JudgeInfo judgeInfo;
}
