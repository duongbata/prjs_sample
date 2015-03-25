package com.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.QuestionDao;
import com.dao.TopicDao;

@Service
public class QuestionNewLogic {
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private TopicDao topicDao;
}
