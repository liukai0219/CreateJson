package com.maven.bean;

import java.io.Serializable;
import java.util.Date;

public class Tags implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String tag;
	private Date created;
	private String createdby;
	private Date update;
	private String updateby;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
	}
	public String getUpdateby() {
		return updateby;
	}
	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}
	@Override
	public String toString() {
		return "Tags [id=" + id + ", tag=" + tag + ", created=" + created + ", createdby=" + createdby + ", update="
				+ update + ", updateby=" + updateby + "]";
	}
}
