package com.exercise.www.util;
/**
 * 페이징 처리를 위한 유틸리티적인 클래스
 * 
 * 
 * @author 황태은
 *
 */
public class PageUtil {
	//변수 선언
	private int nowPage;	//현재 페이지
	private int totalCount;		//총 게시물수
	
	private int pageRow;		//한 게시물당 보여줄 게시물수
	private int pageGroup;		//한 화면당 이동가능 페이지 수
	
	private int startPage;		//해당화면에서 나타날 이동 시작 페이지
	private int endPage;		//
	
	private int startCont;		// 현재페이지에서 보여줄 시작 게시물 번호
	private int endCont;		// 현재 페이지에서 보여줄 마지막 게시물 번호
	
	private int totalPage;		//총 페이지 수
	
	public PageUtil() {
		this(1, 0);
	}
	
	public void setVar(int nowPage, int totalCount,int pageRow, int pageGroup) {
		this.nowPage = nowPage;
		this.totalCount = totalCount;
		this.pageRow = pageRow;
		this.pageGroup = pageGroup;
		
		//나머지 변수를 계산해서 채워준다.	
		calcPage();
		calcStart();
		calcEnd();
		calcCont();
	}
	
	public PageUtil(int nowPage, int totalCount) {
		this.nowPage = nowPage;
		this.totalCount = totalCount;
		this.pageRow = 10;
		this.pageGroup = 3;
	}
	
	//총 페이지 수를 계산하는 함수
	public void calcPage() {
		/*
		 	총 페이지수는 총 게시물 수를 한 화면에 표시할 게시물 갯수로 나누면 된다.
		 	단, 경우에 따라서는 한 페이지가 증가 될수 있다.
		 */
		totalPage = (totalCount % pageRow ==0) ? (totalCount / pageRow) : (totalCount / pageRow +1);
	}
	
	// 시작 페이지를 계산할 함수
	public void calcStart() {
		// 현재 보는 페이지의 그룹을 계산하고
		int tmpGroup = (nowPage - 1) / pageGroup;
		
		// 현재 보는 페이지 그룹의 시작 페이지 번호를 계산
		startPage = tmpGroup * pageGroup + 1;
	}
	
	// 시작과 종료게시물 번호 계산해주는 함수
	public void calcEnd() {
		//startCont = ()
	}
	
	// 종료 페이지 숫자를 계산해주는 함수
	public void calcCont() {
		startCont = (nowPage - 1) * pageRow + 1;
		endCont = nowPage * pageRow;
	}
	

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageRow() {
		return pageRow;
	}

	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}

	public int getPageGroup() {
		return pageGroup;
	}

	public void setPageGroup(int pageGroup) {
		this.pageGroup = pageGroup;
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

	public int getStartCont() {
		return startCont;
	}

	public void setStartCont(int startCont) {
		this.startCont = startCont;
	}

	public int getEndCont() {
		return endCont;
	}

	public void setEndCont(int endCont) {
		this.endCont = endCont;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
