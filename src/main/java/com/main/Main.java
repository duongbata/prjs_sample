package com.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.QuestionBean;
import com.dao.QuestionDao;
import com.logic.GenericLogic;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context/application_context.xml");
		GenericLogic genericLogic = context.getBean(GenericLogic.class);
		genericLogic.insertQuestPlusToFake();
	}
}
