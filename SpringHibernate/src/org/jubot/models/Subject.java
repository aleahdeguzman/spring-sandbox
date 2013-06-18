package org.jubot.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Subject")
public class Subject {
	@Id
	private int studNo;
	private String subj_name;
	
	
	public int getStudNo() {
		return studNo;
	}
	public void setStudNo(int studNo) {
		this.studNo = studNo;
	}
	public String getSubj_name() {
		return subj_name;
	}
	public void setSubj_name(String subj_name) {
		this.subj_name = subj_name;
	}

	

}
