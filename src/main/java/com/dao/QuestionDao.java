package com.dao;

import java.util.List;
import java.util.Map;

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
	
	public static final String  SELECT_QUEST_FROM_ULTRA_BY_TOPIC_ID ="selectQuestFromUltraByTopicId";
	
	public static final String SELECT_ALL_QUEST_FROM_MASTER_EXCEPT_ALTP = "selectAllQuestionFromMasterExceptAltp";
	
	public static final String INSERT_TO_QUEST_NEW = "insertToQuestionNew";
	
	public static final String INSERT_TO_QUEST_TOPIC_MASTER = "insertToQuestionTopicMaster";
	
	public static final String SELECT_QUEST_NEW_BY_TOPIC_ID = "selectQuestNewByTopicId";
	
	@Autowired
	private SqlSessionTemplate plusSqlSession; 
	
	@Autowired
	private SqlSessionTemplate fakeSqlSession;
	
	@Autowired
	private SqlSessionTemplate ultraSqlSession;
	
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
	
	public List<QuestionBean> selectQuestFromUltraByTopicId(String topicId) {
		String query  = namespace + "." +SELECT_QUEST_FROM_ULTRA_BY_TOPIC_ID;
		return ultraSqlSession.selectList(query, topicId);
	}
	
//	quest new 
	public List<QuestionBean> selectAllQuestionFromMasterExceptAltp() {
		String query = namespace + "." + SELECT_ALL_QUEST_FROM_MASTER_EXCEPT_ALTP;
		return fakeSqlSession.selectList(query);
	} 
	
	public boolean insertToQuestionNew(QuestionBean question) {
		String query = namespace + "." + INSERT_TO_QUEST_NEW;
		int result = fakeSqlSession.insert(query, question);
		if (result == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean insertToQuestionTopicMaster(Map<String, Object> map) {
		String query = namespace + "." + INSERT_TO_QUEST_TOPIC_MASTER;
		int result = fakeSqlSession.insert(query, map);
		if (result == -1) {
			return false;
		} else {
			return true;
		} 
	}
	
	public List<QuestionBean> selectQuestNewByTopicId(String topicId) {
		String query = namespace + "." + SELECT_QUEST_NEW_BY_TOPIC_ID;
		return fakeSqlSession.selectList(query, topicId);
	}
	
	private void setNamespace(String namespace) {
		this.namespace = namespace;
	}
}
