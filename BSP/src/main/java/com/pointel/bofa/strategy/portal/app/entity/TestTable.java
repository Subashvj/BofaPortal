package com.pointel.bofa.strategy.portal.app.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class TestTable {

	@Id
	private int id;
	private Date dateColumn;
	private Date timestampColumn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateColumn() {
		return dateColumn;
	}
	public void setDateColumn(Date dateColumn) {
		this.dateColumn = dateColumn;
	}
	public Date getTimestampColumn() {
		return timestampColumn;
	}
	public void setTimestampColumn(Date timestampColumn) {
		this.timestampColumn = timestampColumn;
	}
}
