package com.bbu.model;

public class Page {
	private int pageCount;// 每页显示多少条信息
	private int totalMessage;// 信息的总条数；
	private int indexPage;// 当前页数是多少；
	private int totalPage;// 总页数，需要计算得来
	private int limitPage;// 给数据库的索引
	// 下面两个表示显示页数的边界
	private int start;// 分页显示的开始页数
	private int end;// 分页显示的结束页数

	public Page(int indexPage, int pageCount, int messageCount) {
		this.indexPage = indexPage;
		this.pageCount = pageCount;
		this.totalMessage = messageCount;
		if (totalMessage % pageCount == 0) {
			totalPage = (totalMessage / pageCount);
		} else {
			totalPage = (totalMessage / pageCount) + 1;
		}
		//每次只显示五页
		this.start = 1;
		this.end = 5;
		if (totalPage <= 5 ) {
			end = totalPage;
		} else {
			this.start = indexPage - 2;
			this.end = indexPage + 2;
			if (start <= 0) {
				start = 1;
				end = 5;
			}
			if (end >= totalPage) {
				start = totalPage - 4;
				end = totalPage;
			}
		}
		limitPage = (indexPage - 1) * pageCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalMessage() {
		return totalMessage;
	}

	public void setTotalMessage(int totalMessage) {
		this.totalMessage = totalMessage;
	}

	public int getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getLimitPage() {
		return limitPage;
	}

	public void setLimitPage(int limitPage) {
		this.limitPage = limitPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
