package cn.hdu.domain;

import java.util.List;

public class Page {

	private int pageNum;
	private int totalRecord;

	private int pageSize = 4;
	private int totalPage;
	
	private int startIndex;
	
	private int startPage;
	private int endPage;
	
	private List<Book> list;
	
	public Page(int pageNum, int totalRecord) {

		this.pageNum = pageNum;
		this.totalRecord = totalRecord;
		
		this.totalPage=(this.totalRecord+this.pageSize-1)/this.pageSize;
		this.startIndex=(this.pageNum-1)*this.pageSize;
		
		if(this.totalPage<=10){
			this.startPage=1;
			this.endPage=this.totalPage;
		}else{
			this.startPage=this.pageNum-4;
			this.endPage=this.pageNum+5;
			
			if(this.startPage<1){
				this.startPage=1;
				this.endPage=10;
			}
			if(this.endPage>this.totalPage){
				this.endPage=this.totalPage;
				this.startPage=this.totalPage-9;
			}
		}
		
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}
	

}
