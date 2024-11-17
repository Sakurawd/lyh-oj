package com.yupi.lyhoj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.lyhoj.mapper.QuestionMapper;
import com.yupi.lyhoj.model.entity.Question;
import com.yupi.lyhoj.service.QuestionService;

import org.springframework.stereotype.Service;

/**
 * @author LYH
 * @description 针对表【question(题目)】的数据库操作Service实现
 * @createDate 2024-11-15 09:45:00
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
        implements QuestionService{

}




