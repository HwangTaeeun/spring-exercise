package com.exercise.www.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.exercise.www.util.PageUtil;
import com.exercise.www.vo.BoardVO;

public class BoardDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//리스트보기
	public List showList(PageUtil page) {
		return sqlSession.selectList("bSQL.showList", page);
	}
	
	//페이징처리
	public int getTotalCont() {
		return sqlSession.selectOne("bSQL.getTotalCount");
	}
	
	//글쓰기
	public int boardWrite(BoardVO bvo) {
		int cnt=sqlSession.update("bSQL.write", bvo );
		
		return cnt;
	}
	
	//글내용보기
	public BoardVO showPost(BoardVO bVO) {
		System.out.println("##### bVO :  " + bVO.getBno());
		BoardVO vo = sqlSession.selectOne("bSQL.showPost", bVO);
		System.out.println("##### vo : " + vo.getTitle());
		System.out.println("##### vo : " + vo.getBno());
		return vo;
	}
	
	//추천 처리하기
	public int chooProcc(int bbno) {
		 
		return sqlSession.update("bSQL.choo",bbno);
	}
}
