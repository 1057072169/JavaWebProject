package entity;

/**
 * @ClassName: Users.java
 * @Description: 用户（管理员）实体类
 * @version: "1.8.0_131"
 * @author: 寇爽
 * @date: 2017年11月14日 下午7:54:10
 */
public class Users {
	//序号
	private int uid;
	//用户名
	private String username;
	//密码
	private String password;
	
	public Users(){
		
	}
	public Users(int uid,String username,String password){
		this.uid = uid;
		this.username = username;
		this.password = password;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
