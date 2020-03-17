package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String orderType;
	String orderBy;
	Date startDate;
	Date endDate;
	int userId;
	
	public OrderDetails(String orderType, String orderBy, Date date, Date date2, int userId) {
		super();
		this.orderType = orderType;
		this.orderBy = orderBy;
		this.startDate = date;
		this.endDate = date2;
		this.userId = userId;
	}
	

	public OrderDetails(int id, String orderType, String orderBy, Date startDate, Date endDate, int userId) {
		super();
		this.id = id;
		this.orderType = orderType;
		this.orderBy = orderBy;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userId = userId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", orderType=" + orderType + ", orderBy=" + orderBy + ", startDate="
				+ startDate + ", endDate=" + endDate + ", userId=" + userId + "]";
	}

}
