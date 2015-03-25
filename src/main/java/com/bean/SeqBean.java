package com.bean;

import java.util.Map;

public class SeqBean {
	private long seqNo;
	
	private Map<String, Object> map;

	/**
	 * @return the seqNo
	 */
	public long getSeqNo() {
		return seqNo;
	}

	/**
	 * @param seqNo the seqNo to set
	 */
	public void setSeqNo(long seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @return the map
	 */
	public Map<String, Object> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
}
