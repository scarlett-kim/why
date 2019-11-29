package kr.or.bit.service;

import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.File;
import net.sf.json.JSONArray;

public class RecentReviewService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException {

		ActionForward forward = null;
		
		int bcode = Integer.parseInt(request.getParameter("bcode"));
		BoardDao dao = new BoardDao();
		ArrayList<File> currentreview = dao.showcurrentreview(bcode);
		JSONArray jsonlist = JSONArray.fromObject(currentreview);

		System.out.println("최근후기 5개야 나오니? " + jsonlist);
		request.setAttribute("data", jsonlist);
		
		forward = new ActionForward();
	  	forward.setPath("/WEB-INF/views/Campingdetail_json.jsp");
	  	
		return forward;
	}

}
