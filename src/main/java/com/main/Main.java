package com.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.QuestionBean;
import com.dao.QuestionDao;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context/application_context.xml");
		QuestionDao questDao = context.getBean(QuestionDao.class);
		List<QuestionBean> listQuest = questDao.selectQuestion();
		
	}
}
