package com.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.SeqBean;

@Repository
public class SeqDao {
	private final static String GET_SEQ_NO = "getSeqNo";
	
	private String namespace;
	
	@Autowired
	private SqlSessionTemplate fakeSqlSession;
	
	public SeqDao() {
		setNamespace("com.dao.SeqDao");
	}
	
	public SeqBean getSeqBean(Map<?, ?> map) {
		String query = namespace + "." + GET_SEQ_NO;
		SeqBean result = fakeSqlSession.selectOne(query,map);
		return result;
	}
	
	public int getSeqNo(Map<?, ?> map) {
		SeqBean seqBean = getSeqBean(map);
		int i = 1;
		if (seqBean != null && seqBean.getSeqNo() > 0) {
			i = (int) (seqBean.getSeqNo() + 1);
		}
		return i;
	}
	
	private void setNamespace(String namespace) {
		this.namespace = namespace;
	}
}
