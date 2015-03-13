package com.bean;

public class QuestionBean {
	private int questionId;
	
	private String questionContent;
	
	private String caseA;
	
	private String caseB;
	
	private String caseC;
	
	private String caseD;
	
	private int trueCaseFlag;
	
	private int topicId;
	
	private String usedFlag;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getCaseA() {
		return caseA;
	}

	public void setCaseA(String caseA) {
		this.caseA = caseA;
	}

	public String getCaseB() {
		return caseB;
	}

	public void setCaseB(String caseB) {
		this.caseB = caseB;
	}

	public String getCaseC() {
		return caseC;
	}

	public void setCaseC(String caseC) {
		this.caseC = caseC;
	}

	public String getCaseD() {
		return caseD;
	}

	public void setCaseD(String caseD) {
		this.caseD = caseD;
	}

	public int getTrueCaseFlag() {
		return trueCaseFlag;
	}

	public void setTrueCaseFlag(int trueCaseFlag) {
		this.trueCaseFlag = trueCaseFlag;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getUsedFlag() {
		return usedFlag;
	}

	public void setUsedFlag(String usedFlag) {
		this.usedFlag = usedFlag;
	}
}
