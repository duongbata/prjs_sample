package com.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.QuestionBean;
import com.dao.QuestionDao;
import com.dao.SeqDao;
import com.dao.TopicDao;

@Service
public class QuestionNewLogic {
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private SeqDao seqDao;
	
	public void insertToQuestionNew() throws Throwable{
		int i =0;
		List<QuestionBean> listAllQuest = questionDao.selectAllQuestionFromMaster();
		
		
		for (QuestionBean quest : listAllQuest) {
			if (i == 1) {
				try {
					int a = Integer.parseInt("xxxx");
				} catch (Exception e) {
					throw new Exception();
				}
			}
			int questId = getSeqNoOfQuestionNew();
			quest.setQuestionId(questId);
			boolean isInsertedToNew = questionDao.insertToQuestionNew(quest);
			if (!isInsertedToNew) {
				System.out.println("------------ Error ---------------");
				throw new Exception();
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", getSeqNoOfQuestionTopicMaster());
			map.put("question_id", quest.getQuestionId());
			map.put("topic_id", quest.getTopicId());
			boolean isInsertToQuestTopicMst = questionDao.insertToQuestionTopicMaster(map);
			if (!isInsertToQuestTopicMst) {
				System.out.println("------------ Error ---------------");
				throw new Exception();
			}
			System.out.println(quest.getQuestionId());
			i++;
		}
	}
	
	public int getSeqNoOfQuestionTopicMaster() {
		Map<String, Object> mapSeq = new HashMap<String, Object>();
		mapSeq.put("table_name", "question_topic_master");
		mapSeq.put("column_name", "id");
		return seqDao.getSeqNo(mapSeq);
	}
	
	public int getSeqNoOfQuestionNew() {
		Map<String, Object> mapQuest = new HashMap<String, Object>();
		mapQuest.put("table_name", "question_master_new");
		mapQuest.put("column_name", "question_id");
		return seqDao.getSeqNo(mapQuest);
	}
}
