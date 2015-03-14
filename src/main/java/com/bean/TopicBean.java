package com.bean;

public class TopicBean {
	private int topicId;
	
	private String topicName;
	
	private int parentTopicId;
	
	private String description;
	
	private String newFlag;
	
	private boolean flagEdit;

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public int getParentTopicId() {
		return parentTopicId;
	}

	public void setParentTopicId(int parentTopicId) {
		this.parentTopicId = parentTopicId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNewFlag() {
		return newFlag;
	}

	public void setNewFlag(String newFlag) {
		this.newFlag = newFlag;
	}

	public boolean isFlagEdit() {
		return flagEdit;
	}

	public void setFlagEdit(boolean flagEdit) {
		this.flagEdit = flagEdit;
	}
}
