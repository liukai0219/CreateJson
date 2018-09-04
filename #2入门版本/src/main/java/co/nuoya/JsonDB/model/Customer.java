package co.nuoya.JsonDB.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	private String operate;
	@SerializedName("_id")
	private String id;
	private String index;
	private String guid;
	@SerializedName("isActive")
	private boolean active;
	private Acount acount;
	private String picture;
	private int age;
	@SerializedName("eyeColor")
	private String eyecolor;
	private String lastName;
	private String firstName;
	private String company;
	private String email;
	private String phone;
	private String address;
	private String about;
	private List<Tags> tags;
	private String favoriteFruit;
	private Date created;
	private String createdby;
	private Date update;
	private String updateby;
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getGuid() {
		return guid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
	public Acount getAccout() {
		return acount;
	}
	public void setAccout(Acount acount) {
		this.acount = acount;
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getEyecolor() {
		return eyecolor;
	}
	public void setEyecolor(String eyecolor) {
		this.eyecolor = eyecolor;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getFavoriteFruit() {
		return favoriteFruit;
	}
	public void setFavoriteFruit(String favoriteFruit) {
		this.favoriteFruit = favoriteFruit;
	}
	@Override
	public String toString() {
		return "Customer [operate=" + operate + ", id=" + id + ", index=" + index + ", guid=" + guid + ", active="
				+ active + ", acount=" + acount + ", picture=" + picture + ", age=" + age + ", eyecolor=" + eyecolor
				+ ", lastName=" + lastName + ", firstName=" + firstName + ", company=" + company + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ",  tags=" + tags.toString()
				+ ", favoriteFruit=" + favoriteFruit + ", created=" + created + ", createdby=" + createdby + ", update="
				+ update + ", updateby=" + updateby + "]";
	}
	
}
