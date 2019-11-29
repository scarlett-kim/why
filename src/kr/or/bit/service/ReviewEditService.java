package kr.or.bit.service;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.File;

public class ReviewEditService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException {

		ActionForward forward = null;

		try {
			int idx = Integer.parseInt(request.getParameter("idx"));
			int ps = Integer.parseInt(request.getParameter("ps"));
			int cp = Integer.parseInt(request.getParameter("cp"));
			int fidx = Integer.parseInt(request.getParameter("fidx"));
			
			BoardDao dao = new BoardDao();
			File reviewedit= dao.detailFileBoard(idx);
			request.setAttribute("reviewedit", reviewedit);
			request.setAttribute("idx", idx);
			request.setAttribute("ps", ps);
			request.setAttribute("cp", cp);
			request.setAttribute("fidx", fidx);

	  		  forward = new ActionForward();
		  	  forward.setPath("/WEB-INF/views/review_edit.jsp");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return forward;
	}
}
