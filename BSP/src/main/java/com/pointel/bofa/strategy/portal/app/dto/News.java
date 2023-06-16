package com.pointel.bofa.strategy.portal.app.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class News {
	@Id
 private int newsId;
 private String newsTitle;
 private String newsDate;
public int getNewsId() {
	return newsId;
}
public void setNewsId(int newsId) {
	this.newsId = newsId;
}


public String getNewsTitle() {
	return newsTitle;
}
public void setNewsTitle(String newsTitle) {
	this.newsTitle = newsTitle;
}

public String getNewsDate() {
	return newsDate;
}
public void setNewsDate(String newsDate) {
	this.newsDate = newsDate;
}
@Override
public String toString() {
	return "News [newsId=" + newsId + ", newsTitle=" + newsTitle + ", newsDate=" + newsDate + ", getNewsId()="
			+ getNewsId() + ", getNewsTitle()=" + getNewsTitle() + ", getNewsDate()=" + getNewsDate() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}

}
