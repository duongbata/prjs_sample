package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.TopicBean;

@Repository
public class TopicDao {
	private static final String LIST_TOPIC_PARENT = "listTopicParent";
	
	private static final String LIST_CHILD_TOPIC_BY_PARENT_ID = "listChildTopicByParent";
	
	@Autowired
	private SqlSessionTemplate plusSqlSession;
	
	
	private String namespace;
	
	public TopicDao() {
		setNamespace("com.dao.TopicDao");
	}
	
	public List<TopicBean> listTopicParent() {
		String query = namespace + "." + LIST_TOPIC_PARENT;
		return plusSqlSession.selectList(query);
	}
	
	public List<TopicBean> listChildTopicByParentId(String parentTopicId) {
		String query = namespace + "." + LIST_CHILD_TOPIC_BY_PARENT_ID;
		return plusSqlSession.selectList(query, parentTopicId);
	}
	
	private void setNamespace(String namespace) {
		this.namespace = namespace;
	}
}
