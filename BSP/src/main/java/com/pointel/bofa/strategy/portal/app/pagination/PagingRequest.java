package com.pointel.bofa.strategy.portal.app.pagination;

import java.util.List;

public class PagingRequest {
	
	private String entity;
	private int page;
	private int perPage;
	private String sort;
	private String sortField;
	private List<Filters> filter;
	
	
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public List<Filters> getFilter() {
		return filter;
	}
	public void setFilter(List<Filters> filter) {
		this.filter = filter;
	}

}
