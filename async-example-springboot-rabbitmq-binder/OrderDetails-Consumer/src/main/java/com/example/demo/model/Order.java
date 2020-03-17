package com.example.demo.model;

public class Order {
	
	String orderType;
	String startDate;
	String endDate;
	
	public Order( String orderType, String startDate, String endDate) {
		super();
		
		this.orderType = orderType;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
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

	@Override
	public String toString() {
		return "Order [orderType=" + orderType + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}
	
}
