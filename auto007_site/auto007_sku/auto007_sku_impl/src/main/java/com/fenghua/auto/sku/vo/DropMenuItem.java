package com.fenghua.auto.sku.vo;
/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年12月3日
  * @version 
  */
public class DropMenuItem {

	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DropMenuItem(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public DropMenuItem(){
		
	}
	
}
