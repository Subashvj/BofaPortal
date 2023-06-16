package com.pointel.bofa.strategy.portal.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RecommendedMembers {
	
			@Id
			@Column(name = "STRAT_ID")
			private int stratId;
			
			@Column(name = "ESTIMATE_GRP")
			private int estimateGRP;
			
			@Column(name = "GROUP_NAME")
			private String groupName;
			
			@Column(name = "OWNER")
			private String owner;
			
			@Column(name = "DISPLAYNAME")
			private String displayName;

			public int getStratId() {
				return stratId;
			}

			public void setStratId(int stratId) {
				this.stratId = stratId;
			}

			public int getEstimateGRP() {
				return estimateGRP;
			}

			public void setEstimateGRP(int estimateGRP) {
				this.estimateGRP = estimateGRP;
			}

			public String getGroupName() {
				return groupName;
			}

			public void setGroupName(String groupName) {
				this.groupName = groupName;
			}

			public String getOwner() {
				return owner;
			}

			public void setOwner(String owner) {
				this.owner = owner;
			}

			public String getDisplayName() {
				return displayName;
			}

			public void setDisplayName(String displayName) {
				this.displayName = displayName;
			}
			
			
			
				
}
