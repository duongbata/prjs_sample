package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.QuestionBean;

@Repository
public class QuestionDao {
	private String namespace;
	
	private static final String SELECT_QUEST_FROM_PLUS_BY_TOPIC = "selectQuestionFromPlusByTopic";
	
	private static final String INSERT_QUEST_TO_FAKE = "insertQuestToFake";
	
	@Autowired
	private SqlSessionTemplate plusSqlSession; 
	
	@Autowired
	private SqlSessionTemplate fakeSqlSession;
	
	public QuestionDao() {
		setNamespace("com.dao.QuestionDao");
	}
	
	public List<QuestionBean> selectQuestion(String topicId) {
		String query = namespace + "." +SELECT_QUEST_FROM_PLUS_BY_TOPIC;
		return plusSqlSession.selectList(query,topicId);
	}
	
	public void insertQuestToFake(QuestionBean quest) {
		String query = namespace + "." + INSERT_QUEST_TO_FAKE;
		fakeSqlSession.insert(query, quest);
	}

	
	private void setNamespace(String namespace) {
		this.namespace = namespace;
	}
}
