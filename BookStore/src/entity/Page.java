package entity;

import java.util.List;

public class Page {
	
	private int totalpage; //锟斤拷住锟斤拷页锟斤拷
	private int pagesize = 3; //页锟斤拷锟叫�	private int totalrecord; //锟杰硷拷录锟斤拷
	private int pagenum; //锟斤拷住锟斤拷前页
	private List list; //锟斤拷住页锟斤拷锟斤拷锟�	private int startpage; //锟斤拷始页锟斤拷
	private int endpage;
	private int startindex; //锟斤拷住锟矫伙拷锟诫看锟斤拷 页锟斤拷锟斤拷荽锟斤拷母锟斤拷胤锟斤拷锟绞既�	
	private int totalrecord;
	private int startpage;
	public Page(int pagenum, int totalrecord){
		this.pagenum = pagenum;
		this.totalrecord = totalrecord;
		//锟斤拷锟斤拷锟揭筹拷锟�		this.totalpage = (this.totalrecord + this.pagesize - 1) / this.pagesize;
		//锟斤拷锟斤拷没锟斤拷肟达拷锟揭筹拷锟斤拷锟捷达拷锟斤拷菘锟斤拷母锟斤拷胤锟斤拷锟绞既�		this.startindex = (this.pagenum - 1) * this.pagesize;
		
		if(this.totalpage <= 3){
			this.startpage = 1;
			this.endpage = this.totalpage;
		}else{
			this.startpage = pagenum - 1;
			this.endpage = pagenum + 1;
			
			if(this.startpage < 1){
				this.startpage = 1;
				this.endpage = 3;
			}
			if(this.endpage > this.totalpage){
				this.endpage = this.totalpage;
				this.startpage = this.totalpage - 2;
			}
		}
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}

	public int getStartindex() {
		return startindex;
	}

	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}
}
