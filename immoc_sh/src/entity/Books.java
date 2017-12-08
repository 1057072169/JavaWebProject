package entity;

import java.util.Date;

/**
 * @ClassName: Books.java
 * @Description: 书的实体类
 * @version: "1.8.0_131"
 * @author: 寇爽
 * @date: 2017年12月8日 上午9:14:18
 */
public class Books {
	// 书籍编号
	private String sid;
	// 书名
	private String sname;
	// 借书日期
	private Date loandate;
	// 书籍剩余数量
	private String total;

	public Books() {

	}

	public Books(String sid, String sname, Date loandate, String total) {
		// super();
		this.sid = sid;
		this.sname = sname;
		this.loandate = loandate;
		this.total = total;
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

	public Date getLoandate() {
		return loandate;
	}

	public void setLoandate(Date loandate) {
		this.loandate = loandate;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Books [sid=" + sid + ", sname=" + sname + ", loandate="
				+ loandate + ", total=" + total + "]";
	}

}
