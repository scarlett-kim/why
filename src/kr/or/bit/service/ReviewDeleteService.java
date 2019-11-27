package kr.or.bit.service;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;

public class ReviewDeleteService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException {
	     ActionForward forward = null; 
	      try {
	         
	         int idx = Integer.parseInt((String) request.getParameter("idx"));
	         int fidx = Integer.parseInt((String) request.getParameter("fidx"));
	         int bcode = Integer.parseInt((String) request.getParameter("bcode"));
	         System.out.println("bcode+idx+fidx" +fidx + idx + bcode);
	         
	         BoardDao dao = new BoardDao();
	         int deletefile  = dao.deleteFile(fidx);
	         request.setAttribute("deletefile", deletefile);
	         int deleteboard = dao.deleteBoard(idx);
	         request.setAttribute("deleteboard", deleteboard);
	         
	         forward = new ActionForward();
	         forward.setPath("/ReviewList.do");
	         
	         
	      }catch (Exception e) {
	         System.out.println(e.getMessage());
	      }   
	      return forward;
	   }

	}


