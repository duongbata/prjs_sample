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
	
	private static final String SELECT_QUEST_FROM_FAKE_BY_TOPIC = "selectQuestFromFakeByTopicId";
	
	public static final String SELECT_WRONGABLE_QUEST = "selectWrongableQuest";
	
	public static final String UPDATE_WRONG_QUEST = "updateWrongQuest";
	
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
	
	public List<QuestionBean> selectQuestFromFakeByTopicId(String topicId) {
		String query = namespace + "." + SELECT_QUEST_FROM_FAKE_BY_TOPIC;
		return fakeSqlSession.selectList(query, topicId);
	}
	
	public List<QuestionBean> selectWrongableQuest(){
		String query = namespace + "." + SELECT_WRONGABLE_QUEST;
		return fakeSqlSession.selectList(query);
	}
	
	public void updateWrongQuest(QuestionBean quest) {
		String query = namespace + "." + UPDATE_WRONG_QUEST;
		fakeSqlSession.update(query, quest);
	}

	
	private void setNamespace(String namespace) {
		this.namespace = namespace;
	}
}
