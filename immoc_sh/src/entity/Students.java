package entity;

import java.util.Date;

/**
 * @ClassName: Students.java
 * @Description: 学生的实体类
 * @version: "1.8.0_131"
 * @author: 寇爽
 * @date: 2017年12月8日 上午9:14:35
 */
public class Students {
	// 学号
	private String sid;
	// 姓名
	private String sname;
	// 性别
	private String gender;
	// 出生日期
	private Date birthday;
	// 地址
	private String address;

	public Students() {

	}

	public Students(String sid, String sname, String gender, Date birthday,
			String address) {
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", gender="
				+ gender + ", birthday=" + birthday + ", address=" + address
				+ "]";
	}

}
