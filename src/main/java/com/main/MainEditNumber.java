package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logic.GenericLogic;

public class MainEditNumber {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context/application_context.xml");
		GenericLogic genericLogic = context.getBean(GenericLogic.class);
		genericLogic.processWrongableQuest();
	}
}
