package com.yupi.lyhoj.judge.strategy;

import com.yupi.lyhoj.model.dto.question.JudgeCase;
import com.yupi.lyhoj.model.dto.questionsubmit.JudgeInfo;
import com.yupi.lyhoj.model.entity.Question;
import com.yupi.lyhoj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * @Author: Sakura
 * @Date: 2024/12/22 17:02
 * @Version: v1.0.0
 * @Description: TODO
 * 上下文(用于定义在策略传递)
 **/
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}
