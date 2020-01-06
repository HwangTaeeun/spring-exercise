package com.exercise.www.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.exercise.www.vo.FileVO;

public class FileDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	//파일정보 입력 전담 처리 함수
	public int insertPhoto(FileVO fvo) {
		return sqlSession.insert("bSQL.addPic",fvo);
	}
	
}
