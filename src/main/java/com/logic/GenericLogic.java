package com.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Constant;
import com.bean.QuestionBean;
import com.bean.TopicBean;
import com.dao.QuestionDao;
import com.dao.TopicDao;

@Service
public class GenericLogic {
	@Autowired
	private TopicDao topicDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	public void insertQuestPlusToFake(){
		List<TopicBean> listParent = topicDao.listTopicParent();
		if (listParent != null && listParent.size() > 0) {
			for (TopicBean parent : listParent) {
				List<TopicBean> listChild = topicDao.listChildTopicByParentId(String.valueOf(parent.getTopicId()));
				for (TopicBean child : listChild) {
					List<QuestionBean> listQuest = questionDao.selectQuestion(String.valueOf(child.getTopicId()));
					for (QuestionBean quest : listQuest) {
						if (parent.getTopicId() == Constant.PLUS_AM_NHAC) {
							quest.setTopicId(Constant.FAKE_AM_NHAC);
							questionDao.insertQuestToFake(quest);
						} else if (parent.getTopicId() == Constant.PLUS_AM_THUC) {
							quest.setTopicId(Constant.FAKE_AM_THUC);
							questionDao.insertQuestToFake(quest);
						} else if (parent.getTopicId() == Constant.PLUS_CELEB) {
							quest.setTopicId(Constant.FAKE_CELEB);
							questionDao.insertQuestToFake(quest);
						} else if (parent.getTopicId() == Constant.PLUS_KH_CN) {
							quest.setTopicId(Constant.FAKE_KH_CN);
							questionDao.insertQuestToFake(quest);
						}else if (parent.getTopicId() == Constant.PLUS_PHIM) {
							quest.setTopicId(Constant.FAKE_PHIM);
							questionDao.insertQuestToFake(quest);
						} else if (parent.getTopicId() == Constant.PLUS_THE_THAO) {
							quest.setTopicId(Constant.FAKE_THE_THAO);
							questionDao.insertQuestToFake(quest);
						} else if (parent.getTopicId() == Constant.PLUS_TV_SHOW) {
							quest.setTopicId(Constant.FAKE_TV_SHOW);
							questionDao.insertQuestToFake(quest);
						} else if (parent.getTopicId() == Constant.PLUS_VH_XH) {
							quest.setTopicId(Constant.FAKE_VH_XH);
							questionDao.insertQuestToFake(quest);
						}
						
					}
				}
			}
		}
	}
}
