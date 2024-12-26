package com.yupi.lyhoj.judge;

import com.yupi.lyhoj.judge.strategy.DefaultJudgeStrategy;
import com.yupi.lyhoj.judge.strategy.JavaLanguageJudgeStrategy;
import com.yupi.lyhoj.judge.strategy.JudgeContext;
import com.yupi.lyhoj.judge.strategy.JudgeStrategy;
import com.yupi.lyhoj.model.dto.questionsubmit.JudgeInfo;
import com.yupi.lyhoj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * @Author: Sakura
 * @Date: 2024/12/26 16:15
 * @Version: v1.0.0
 * @Description: TODO
 * 判题管理（简化调用）
 *
 **/
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
