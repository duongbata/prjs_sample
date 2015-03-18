package com.logic;

import java.util.ArrayList;
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
			int i = 1;
			for (TopicBean parent : listParent) {
				List<TopicBean> listChild = topicDao.listChildTopicByParentId(String.valueOf(parent.getTopicId()));
				for (TopicBean child : listChild) {
					List<QuestionBean> listQuest = questionDao.selectQuestion(String.valueOf(child.getTopicId()));
					for (QuestionBean quest : listQuest) {
						if (parent.getTopicId() == Constant.PLUS_AM_NHAC) {
							if (quest.getTopicId() == Constant.PLUS_AM_NHAC_TRONG_NUOC) {
								quest.setTopicId(Constant.FAKE_AM_NHAC_TRONG_NUOC);
								questionDao.insertQuestToFake(quest);
							} else if (quest.getTopicId() == Constant.PLUS_AM_NHAC_NUOC_NGOAI){
								quest.setTopicId(Constant.FAKE_AM_NHAC_NUOC_NGOAI);
								questionDao.insertQuestToFake(quest);
							}
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
						System.out.println(i);
						i++;
					}
				}
			}
		}
	}
	
	//copy quest from old topic to new topic
	public void insertQuestFromOldToNewTopic(List<String> listTopicId, int newTopicId) {
		for (String topicId : listTopicId) {
			List<QuestionBean> listQuestOfTopic = questionDao.selectQuestFromFakeByTopicId(topicId);
			System.out.println(topicId);
			for (QuestionBean quest : listQuestOfTopic) {
				quest.setTopicId(Integer.valueOf(newTopicId));
				questionDao.insertQuestToFake(quest);
				System.out.println("	"+quest.getQuestionId());
			}
		}
	}
	
	public void insertToTopicNhacNuocNgoaiInFake() {
		List<String> listTopicId = new ArrayList<String>();
		listTopicId.add(String.valueOf(Constant.FAKE_NHAC_HAN_QUOC));
		listTopicId.add(String.valueOf(Constant.FAKE_NHAC_AU_MY));
		listTopicId.add(String.valueOf(Constant.FAKE_NHAC_CO_DIEN));
		
		int newTopicId = Constant.FAKE_AM_NHAC_NUOC_NGOAI;
		insertQuestFromOldToNewTopic(listTopicId, newTopicId);
	}
	
	public void insertToTopicNhactrongNuocInFake() {
		List<String> listTopicId = new ArrayList<String>();
		listTopicId.add(String.valueOf(Constant.FAKE_NHAC_TRE));
		listTopicId.add(String.valueOf(Constant.FAKE_NHAC_TRU_TINH));
		listTopicId.add(String.valueOf(Constant.FAKE_NHAC_CACH_MANG));
		listTopicId.add(String.valueOf(Constant.FAKE_NHAC_THIEU_NHI));
		
		int newTopicId = Constant.FAKE_AM_NHAC_TRONG_NUOC;
		insertQuestFromOldToNewTopic(listTopicId, newTopicId);
	}
	
	public void insertToTopicKHCNInFake() {
		List<String> listTopicId = new ArrayList<String>();
		listTopicId.add(String.valueOf(Constant.FAKE_KHOA_HOC_CHUNG));
		listTopicId.add(String.valueOf(Constant.FAKE_KHOA_HOC_MAY_TINH));
		listTopicId.add(String.valueOf(Constant.FAKE_KHOA_HOC_VU_TRU));
		listTopicId.add(String.valueOf(Constant.FAKE_THIEN_VAN_HOC));
		
		int newTopicId = Constant.FAKE_KH_CN;
		insertQuestFromOldToNewTopic(listTopicId, newTopicId);
	}
	
	public void insertToTopicVHXHInFake() {
		List<String> listTopicId = new ArrayList<String>();
		listTopicId.add(String.valueOf(Constant.FAKE_GIAO_THONG));
		listTopicId.add(String.valueOf(Constant.FAKE_THOI_TRANG));
		
		int newTopicId = Constant.FAKE_VH_XH;
		insertQuestFromOldToNewTopic(listTopicId, newTopicId);
	}
}
