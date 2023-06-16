package com.pointel.bofa.strategy.portal.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class EstimateGroups {

	@Id
	@SequenceGenerator(name="EstimateGroupsSequence",sequenceName="ESTIMATE_GROUPS_ESTIMATE_G_SEQ",allocationSize=1)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EstimateGroupsSequence")
	private int estimateGrp;
	private String groupName;
	public int getEstimateGrp() {
		return estimateGrp;
	}
	public void setEstimateGrp(int estimateGrp) {
		this.estimateGrp = estimateGrp;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}	
}
