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

public class MyTradePageService implements Action{

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException {
      //bcode, id, tcode, 
      
      ActionForward forward = null;
      int bcode = Integer.parseInt(request.getParameter("bcode"));
      int tcode = Integer.parseInt(request.getParameter("tcode"));
      String id = request.getParameter("id");
      
      BoardDao dao = new BoardDao();
      List<File> mytradelist = dao.showMyReview(bcode, id);
      JSONArray jsonlist = JSONArray.fromObject(mytradelist);
      System.out.println("마이 페이지 트레이드 후기야 나오니? " + jsonlist);
      
      request.setAttribute("tradedata", jsonlist);

      forward = new ActionForward();
        forward.setPath("/WEB-INF/views/Campingtradedetail_json.jsp");
        
      return forward;
   }

}