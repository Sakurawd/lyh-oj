package com.yupi.lyhoj.judge.strategy;

import com.yupi.lyhoj.model.dto.questionsubmit.JudgeInfo;

/**
 * @Author: Sakura
 * @Date: 2024/12/22 16:43
 * @Version: v1.0.0
 * @Description: TODO
 **/
public interface JudgeStrategy {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
