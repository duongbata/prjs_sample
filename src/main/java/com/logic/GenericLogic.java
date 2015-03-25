package com.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Constant;
import com.bean.ConstantMobi;
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
	
	public void processWrongableQuest(){
		List<QuestionBean> listQuest = questionDao.selectWrongableQuest();
		for (QuestionBean quest : listQuest) {
			boolean isWrong = false;
			
			String[] arrCaseA = quest.getCaseA().split("\\.");
			if (arrCaseA.length > 1 && "0".equals(arrCaseA[1])) {
				isWrong = true;
				quest.setCaseA(arrCaseA[0]);
			}
			
			String[] arrCaseB = quest.getCaseB().split("\\.");
			if (arrCaseB.length > 1 && "0".equals(arrCaseB[1])) {
				isWrong = true;
				quest.setCaseB(arrCaseB[0]);
			}
			
			String[] arrCaseC = quest.getCaseC().split("\\.");
			if (arrCaseC.length > 1 && "0".equals(arrCaseC[1])) {
				isWrong = true;
				quest.setCaseC(arrCaseC[0]);
			}
			
			String[] arrCaseD = quest.getCaseD().split("\\.");
			if (arrCaseD.length > 1 && "0".equals(arrCaseD[1])) {
				isWrong = true;
				quest.setCaseD(arrCaseD[0]);
			}
			if (isWrong) {
				System.out.println(quest.getQuestionId());
				questionDao.updateWrongQuest(quest);
			}
		}
	}
	
	//Ultra
	public void insertQuestFromUltraToFake(int fromTopicUltra, int toTopicFake) {
		List<QuestionBean> listQuestFromUltra = questionDao.selectQuestFromUltraByTopicId(String.valueOf(fromTopicUltra));
		System.out.println(String.valueOf(toTopicFake));
		for (QuestionBean quest : listQuestFromUltra) {
			quest.setTopicId(toTopicFake);
			questionDao.insertQuestToFake(quest);
		}
	}
	
	public void insertAllQuestUltraToFake() {
		insertQuestFromUltraToFake(ConstantMobi.ULTRA_DIA_LY, ConstantMobi.FAKE_DIA_LY);
		insertQuestFromUltraToFake(ConstantMobi.ULTRA_HOA_HOC, ConstantMobi.FAKE_HOA_HOC);
		insertQuestFromUltraToFake(ConstantMobi.ULTRA_LICH_SU, ConstantMobi.FAKE_LICH_SU);
		insertQuestFromUltraToFake(ConstantMobi.ULTRA_NGU_VAN, ConstantMobi.FAKE_NGU_VAN);
		insertQuestFromUltraToFake(ConstantMobi.ULTRA_SINH_HOC, ConstantMobi.FAKE_SINH_HOC);
		insertQuestFromUltraToFake(ConstantMobi.ULTRA_TIENG_ANH, ConstantMobi.FAKE_TIENG_ANH);
		insertQuestFromUltraToFake(ConstantMobi.ULTRA_TOAN_HOC, ConstantMobi.FAKE_TOAN_HOC);
		insertQuestFromUltraToFake(ConstantMobi.ULTRA_VAT_LY, ConstantMobi.FAKE_VAT_LY);
	}
	
	
}
