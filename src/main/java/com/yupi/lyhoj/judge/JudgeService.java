package com.yupi.lyhoj.judge;

import com.yupi.lyhoj.model.dto.questionsubmit.JudgeInfo;
import com.yupi.lyhoj.model.entity.QuestionSubmit;
import com.yupi.lyhoj.model.vo.QuestionSubmitVO;

/**
 * @Author: Sakura
 * @Date: 2024/12/20 21:12
 * @Version: v1.0.0
 * @Description: TODO
 **/
public interface JudgeService {

    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
