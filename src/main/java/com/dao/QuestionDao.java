package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.QuestionBean;

@Repository
public class QuestionDao {
	private String namespace;
	
	private static final String SELECT_QUEST = "selectQuestion";
	
	@Autowired
	private SqlSessionTemplate appSqlSession; 
	
	public QuestionDao() {
		setNamespace("com.dao.QuestionDao");
	}
	
	public List<QuestionBean> selectQuestion() {
		String query = namespace + "." +SELECT_QUEST;
		return appSqlSession.selectList(query);
	}

	
	private void setNamespace(String namespace) {
		this.namespace = namespace;
	}
}
