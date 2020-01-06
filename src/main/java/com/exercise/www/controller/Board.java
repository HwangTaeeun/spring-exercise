package com.exercise.www.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.exercise.www.dao.BoardDAO;
import com.exercise.www.dao.FileDAO;
import com.exercise.www.services.FileService;
import com.exercise.www.util.PageUtil;
import com.exercise.www.vo.BoardVO;
	

@Controller
@RequestMapping("/board/")
public class Board {

	@Autowired
	BoardDAO dao;
	@Autowired
	FileService fileSrvc;
	@Autowired
	FileDAO fDAO;

	/*게시판리스트 보기*/
	@RequestMapping("boardView.van")
	public ModelAndView boardView(ModelAndView mv, PageUtil pageUtil) {
		int nowPage = 1;
		// 할일
		// 게시물 전체 갯수를 구하고
		int total =  dao.getTotalCont();
		System.out.println(total);
		System.out.println("nowPage : " + nowPage);
		if(pageUtil.getNowPage() == 0) {
			nowPage = 1;
		}else {
			nowPage = pageUtil.getNowPage();
		}
		//2.pageUtil 데이터 셋팅
		pageUtil.setVar(nowPage, total, 10, 3);
		
		//3.질의명령 보내고 결과받고
		
		List list = dao.showList(pageUtil);
		
		System.out.println("list size : " + list.size());
		mv.addObject("LIST", list);
		mv.addObject("PAGE", pageUtil);
		
		mv.setViewName("board/bboard");
				
	return mv;
	}
	
	/* 글 내용보기 */
	@RequestMapping("viewPost.van")
	public ModelAndView viewPost(ModelAndView mv, BoardVO bVO) {
		System.out.println("######## " + bVO.getBno());
		int tno = bVO.getBno();
		bVO = dao.showPost(bVO);
		bVO.setBno(tno);
		System.out.println("######## " + bVO.getBno());
		mv.addObject("DATA", bVO);
		mv.setViewName("board/post");
		return mv;
	}
	
	/*글쓰기 뷰 보기*/
	@RequestMapping("writeForm.van")
	public ModelAndView writeForm(ModelAndView mv) {
		
		mv.setViewName("board/writeForm");
		return mv;
	}
	
	/*글쓰기*/
	@RequestMapping("writeProc.van")
	public ModelAndView writeProc(HttpSession session, RedirectView rv, ModelAndView mv, BoardVO bvo) {
		System.out.println("bid=======" + bvo.getBid());
		
		int cnt = dao.boardWrite(bvo);
		System.out.println(bvo.toString());
		if(cnt==1) {
			session.setAttribute("SID",bvo.getBid());
			fileSrvc.setDAO(fDAO);
			fileSrvc.singleUpProc(session, bvo);
			
			rv.setUrl("/www/board/boardView.van");
		}else {
			rv.setUrl("/www/board/writeForm.van");
		}
		mv.setView(rv);
		return mv;
	}
	
	
	/*추천 처리하기*/
	/*
	 * 자바스크립트는  읽을 수 없기 떄문에 json같은 전송 방식 해야하는데
	 * jsp 같은경우는 printwriter라는 스트림으로 넘겨주지만
	 * spring 같은 경우는 @ResoponseBody 라는 것이 있기때문이 이것을 사용하면 된다.
	 */
	
	  @RequestMapping("choo.van")
	  @ResponseBody
	  public int chooProc(@RequestParam int bbno) {
		  int cnt = dao.chooProcc(bbno);
		  
		  return cnt;
	  }
	 
}
