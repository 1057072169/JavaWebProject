package entity;

import java.util.Date;

/**
 * @ClassName: Friends.java
 * @Description: Friends实体类
 * @version: "1.8.0_131"
 * @author: 寇爽
 * @date: 2017年11月13日 下午12:24:24
 */
public class Friends {
	//序号
	private int id;
	//姓名
	private String name;
	//年龄
	private int age;
	//电话
	private String phonenum;
	//生日
	private Date date;
	//爱好
	private String favorite;
	
	public Friends() {
		super();
	}
	public Friends(int id, String name, int age, String phonenum, Date date,
			String favorite) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phonenum = phonenum;
		this.date = date;
		this.favorite = favorite;
	}
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	@Override
	public String toString() {
		return "Friends [id=" + id + ", name=" + name + ", age=" + age
				+ ", phonenum=" + phonenum + ", date=" + date + ", favorite="
				+ favorite + "]";
	}

}
