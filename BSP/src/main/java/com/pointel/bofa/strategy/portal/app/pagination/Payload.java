package com.pointel.bofa.strategy.portal.app.pagination;

import java.util.List;

public class Payload<T> {

	
	    private List<T> gridData;
	    //private int recordsFiltered;
	    private int totalCount;
	    private String other;
	    
	    public Payload() {}
	    
	    public Payload(List<T> gridData) {
	        this.gridData = gridData;
	    }

		
		/*
		 * public List<T> getData() { return gridData; }
		 * 
		 * public void setData(List<T> data) { this.gridData = gridData; }
		 */
		 

		public List<T> getGridData() {
			return gridData;
		}

		public void setGridData(List<T> gridData) {
			this.gridData = gridData;
		}

		public int getTotalCount() {
			return totalCount;
		}

		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}

		public String getOther() {
			return other;
		}

		public void setOther(String other) {
			this.other = other;
		}
		
}
