package com.aartek.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT_DETAILS")
public class ProjectDetailsDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer pNo;
	
	@Column(name="P_NAME",length=15)
	private String projectName;
	@Column(name="CLIENT",length=15)
	private String client;
	@Column(name="S_DATE",length=10)
	private String startDate;
	@Column(name="E_DATE",length=10)
	private String endDate;

	public Integer getpNo() {
		return pNo;
	}
	public void setpNo(Integer pNo) {
		this.pNo = pNo;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
