package com.springinaction.database.DO;

import java.util.Date;

public class OrderDO {
	private long id;
	private String taobaoOrderId;
	private String taobaoUserName;
	private String items;
	private float price;
	private Date createTime;
	private Date modifyTime;
	private char isFinished;
	
	
	public void setId(long id){
		this.id = id;
	}
	public long getId(){
		return id;
	}
	
	public void setTaobaoOrderId(String taobaoOrderId){
		this.taobaoOrderId = taobaoOrderId;
	}
	public String getTaobaoOrderId(){
		return taobaoOrderId;
	}
	
	public void setTaobaoUserName(String taobaoUserName){
		this.taobaoUserName = taobaoUserName;
	}
	public String getTaobaoUserName(){
		return taobaoUserName;
	}

	
	
	public void setItems(String items){
		this.items = items;
	}
	public String getItems(){
		return items;
	}
	
	public void setPrice(float price){
		this.price = price;
	}
	public float getPrice(){
		return price;
	}
	

	public Date getCreateTime(){
		return createTime;
	}
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	
	public Date getModifyTime(){
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime){
		this.modifyTime = modifyTime;
	}
	
	public void setIsFinished(char isFinished){
		this.isFinished = isFinished;
	}
	public char getIsFinished(){
		return isFinished;
	}
}
