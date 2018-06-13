package com.maven.bean;

import java.io.Serializable;

/**
 * @author LiuKai
 *
 */
public class Tag implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String customer_id;
	private String tag;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	@Override
	public String toString() {
		return "Tag [id=" + id + ", customer_id=" + customer_id + ", tag=" + tag + "]";
	}
}
