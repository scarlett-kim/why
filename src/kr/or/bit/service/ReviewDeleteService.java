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
	         String board_msg="";
	 	  	String board_url="";
	         BoardDao dao = new BoardDao();
	         int deletefile  = dao.deleteFile(fidx);
	         request.setAttribute("deletefile", deletefile);
	         int deleteboard = dao.deleteBoard(idx);
	         request.setAttribute("deleteboard", deleteboard);
	         
	         forward = new ActionForward();
	         if(deletefile > 0 || deleteboard>0) {
	 	  		board_msg ="삭제성공";
	 	  		board_url ="ReviewList.do?bcode="+bcode;
	 	  	}else { //-1 (제약, 컬럼길이 문제)
	 	  		board_msg ="삭제실패";
	 	  		board_url ="ReviewList.do?bcode="+bcode;
	 	  	}
	 	  	request.setAttribute("board_msg", board_msg);
	 	  	request.setAttribute("board_url", board_url);
	 	  	  
	 		//이동경로 설정
	 	  	forward.setPath("/WEB-INF/redirect.jsp");
	         
	      }catch (Exception e) {
	         System.out.println(e.getMessage());
	      }   
	      return forward;
	   }

	}


