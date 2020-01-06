package com.exercise.www.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.exercise.www.dao.MemberDAO;
import com.exercise.www.vo.*;

@Controller
@RequestMapping("/member/")
public class Member {
	
	@Autowired
	MemberDAO dao;
	
	/* 로그인 관련 */
	@RequestMapping("login.van")
	public ModelAndView loginForm(ModelAndView mv) {
		
		mv.setViewName("member/login");
		return mv;
	}
	
	@RequestMapping("loginProc.van")
	public ModelAndView loginProc(HttpSession session,RedirectView rv,ModelAndView mv,MemberVO vo) {
		/*
		 	HttpSession session =req.getSession();
		 	String sid= (String)session.getAttribute("SID");
		 	session.setAttribute("SID",sid);
		 */
		int cnt = dao.loginProc(vo);
		
		if(cnt==1) {
			session.setAttribute("SID", vo.getId());
			rv.setUrl("/www");
		}else {
			rv.setUrl("/www/member/login.van");
		}
		mv.setView(rv);
		
	return mv;
	}
	
	@RequestMapping("logoutProc.van")
	public ModelAndView logoutProc(HttpSession session,RedirectView rv,ModelAndView mv) {
		
	session.setAttribute("SID", "");
	rv.setUrl("/www");
	mv.setView(rv);
	return mv;
	}

	
}
