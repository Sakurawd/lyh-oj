package com.yupi.lyhoj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.lyhoj.annotation.AuthCheck;
import com.yupi.lyhoj.common.BaseResponse;
import com.yupi.lyhoj.common.ErrorCode;
import com.yupi.lyhoj.common.ResultUtils;
import com.yupi.lyhoj.constant.UserConstant;
import com.yupi.lyhoj.exception.BusinessException;
import com.yupi.lyhoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.lyhoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yupi.lyhoj.model.entity.QuestionSubmit;
import com.yupi.lyhoj.model.entity.User;
import com.yupi.lyhoj.model.vo.QuestionSubmitVO;
import com.yupi.lyhoj.service.QuestionSubmitService;
import com.yupi.lyhoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 点赞 / 取消点赞
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return resultNum 提交记录的ID
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
            HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        Long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }
    /**
     * 分页获取题目提交列表（管理员可看到其他人的答案 普通用户只能看到自己的答案和别人的非答案，提交的代码等公开信息）
     *
     * @param questionSubmitQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
                                                                         HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        final User loginUser = userService.getLoginUser(request);
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
    }

}
