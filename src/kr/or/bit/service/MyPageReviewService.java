package kr.or.bit.service;

import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.File;
import net.sf.json.JSONArray;

public class MyPageReviewService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		//bcode, id, tcode, 
		
		ActionForward forward = null;
		int bcode = Integer.parseInt(request.getParameter("bcode"));
		int tcode = Integer.parseInt(request.getParameter("tcode"));
		String id = request.getParameter("id");
		
		BoardDao dao = new BoardDao();
		List<File> myreviewlist = dao.showMyReview(bcode, id);
		JSONArray jsonlist = JSONArray.fromObject(myreviewlist);
		System.out.println("마이리스트 후기야 나오니? " + jsonlist);
		
		request.setAttribute("data", jsonlist);

		forward = new ActionForward();
	  	forward.setPath("/WEB-INF/views/Campingdetail_json.jsp");
	  	
		return forward;
	}

}
