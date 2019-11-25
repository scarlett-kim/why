package kr.or.bit.service;

import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

public class ReviewListService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward = null;

		try {
			int bcode = Integer.parseInt(request.getParameter("bcode"));
			System.out.println("비코드 오니?" +bcode);  //yes.
			
			BoardDao dao = new BoardDao();
			List<Board> reviewlist= dao.showBoard(bcode);
			request.setAttribute("reviewlist", reviewlist);
			
	  		  forward = new ActionForward();
		  	  forward.setPath("/reviewList.jsp");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return forward;
	}
}
