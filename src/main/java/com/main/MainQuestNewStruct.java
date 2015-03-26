package com.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.QuestionBean;
import com.dao.QuestionDao;
import com.dao.SeqDao;
import com.logic.GenericLogic;
import com.logic.QuestionNewLogic;

public class MainQuestNewStruct {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context/application_context.xml");
		QuestionNewLogic questNewLogic = context.getBean(QuestionNewLogic.class);
		try {
			//insert quest
			questNewLogic.insertToQuestionNew();
			
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
}
