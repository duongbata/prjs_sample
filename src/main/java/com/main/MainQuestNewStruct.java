package com.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.SeqDao;
import com.logic.GenericLogic;
import com.logic.QuestionNewLogic;

public class MainQuestNewStruct {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context/application_context.xml");
//		QuestionNewLogic questNewLogic = context.getBean(QuestionNewLogic.class);
		SeqDao seqDao = context.getBean(SeqDao.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("table_name", "question_master");
		map.put("column_name", "question_id");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("topic_id", 107);
		params.put("used_flag", "1");
		map.put("params", params);
		System.out.println(seqDao.getSeqNo(map));
	}
}
