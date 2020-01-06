package com.exercise.www.vo;

import java.sql.Date;

public class FileVO {

	private int pno;
	private String fid;
	private String oriName;
	private String saveName;
	private long len;
	private String dir;
	private Date pDate;
	private String spDate;
	
	
	
	
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public long getLen() {
		return len;
	}
	public void setLen(long len) {
		this.len = len;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = "/resources/upload";
		//this.dir = dir;	
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	
	
	public String getSpDate() {
		return spDate;
	}
	public void setSpDate(String spDate) {
		this.spDate = spDate;
	}
	
	
	
	
	
}
