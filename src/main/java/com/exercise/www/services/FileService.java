package com.exercise.www.services;

import java.io.File;

import javax.servlet.http.HttpSession;

import com.exercise.www.dao.FileDAO;
import com.exercise.www.util.FileUtil;
import com.exercise.www.vo.BoardVO;
import com.exercise.www.vo.FileVO;
import com.exercise.www.vo.*;

public class FileService {
	FileDAO fDAO;
	
	public void setDAO(FileDAO fDAO) {
		this.fDAO = fDAO;
	}
	
	//단일 파일 업로드 처리할 함수
	public String singleUpProc(HttpSession session, BoardVO bVO) {
		
		
		String saveName="";
		long len = 0;
		
		String spath = session.getServletContext().getRealPath("resources/upload");
		String rePath = "D:\\proprac\\source\\spring-exercise\\src\\main\\webapp\\resources\\upload";
		System.out.println(spath);
		
		String oriName="";
		try {
			oriName = bVO.getsFile().getOriginalFilename();
		}catch(Exception e) {
			return oriName;
		}
		
		saveName = FileUtil.rename(spath, oriName);
		
		try {
			File file = new File(spath, saveName);
			bVO.getsFile().transferTo(file);
			
			len = bVO.getsFile().getSize();
			file = new File(rePath, saveName);
			
			//작업경로에 복사
			file = new File(rePath, saveName);
			bVO.getsFile().transferTo(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		FileVO fVO = new FileVO();
		fVO.setPno(bVO.getBno());
		fVO.setFid(bVO.getBid());
		fVO.setOriName(oriName);
		fVO.setSaveName(saveName);
		fVO.setDir(fVO.getDir());
		fVO.setLen(len);
		System.out.println("*****len ==" + len);
		int cnt = fDAO.insertPhoto(fVO);
		System.out.println("fdao.insert ======"+cnt);
		return saveName;
	}

}
